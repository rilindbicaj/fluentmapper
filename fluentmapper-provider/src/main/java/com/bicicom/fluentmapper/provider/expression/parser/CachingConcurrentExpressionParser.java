package com.bicicom.fluentmapper.provider.expression.parser;

import com.bicicom.fluentmapper.expression.Expression;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.lang.invoke.SerializedLambda;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

/**
 * Expression parser for usage in a concurrent environment. Caches each model class file read, together with
 * all it's methods, so it only reads a model class once.
 */
public final class CachingConcurrentExpressionParser extends ExpressionParser {
    private static final Logger logger = LoggerFactory.getLogger(CachingConcurrentExpressionParser.class);
    private final ConcurrentMap<String, Map<String, MethodNode>> classLambdas = new ConcurrentHashMap<>();

    @Override
    public ExpressionMetadata parse(Expression<?, ?> expression) {
        final SerializedLambda serializedLambda = toSerializedLambda(expression);

        final String containingClass = serializedLambda.getImplClass();
        final String lambdaSignature = serializedLambda.getImplMethodName();
        final MethodNode expressionLambda;

        if (classLambdas.get(containingClass) == null) {

            logger.debug("Attempting to cache expressions in {}", containingClass);
            // If not present in cache, read the class and cache its methods
            final ClassReader classReader;

            try {
                final InputStream classfileStream = modelClassLoader
                        .getClassLoader()
                        .getResourceAsStream(
                                containingClass.replace('.', '/') + ".class"
                        );

                if (classfileStream == null) {
                    throw new IOException("Could not create inputstream to class file " + containingClass);
                }

                classReader = new ClassReader(classfileStream);
            } catch (IOException e) {
                throw new ExpressionParseException("Unable to read class file for " + containingClass + ";", e);
            }

            final ClassNode node = new ClassNode();

            classReader.accept(node, 0);

            final Map<String, MethodNode> methodsWithNodesMap = node.methods.stream()
                    .distinct()
                    .collect(Collectors.toConcurrentMap(
                            method -> method.name,
                            methodNode -> methodNode,
                            // TODO - Handle duplicate keys more elegantly
                            (a, b) -> a // ignores duplicate keys for now
                    ));
            // Could go one step further and .filter() methods that start with 'lambda' but not worth it
            this.classLambdas.putIfAbsent(containingClass, methodsWithNodesMap);

            logger.debug("Cached expresions in class {}", containingClass);
        }

        expressionLambda = this.classLambdas.get(containingClass).get(lambdaSignature);

        final String accessedProperty = findAccessedProperty(expressionLambda);
        final String[] classes = classExtractor.extract(serializedLambda, accessedProperty);

        return new ExpressionMetadata(accessedProperty, classes[0], classes[1]);
    }

}
