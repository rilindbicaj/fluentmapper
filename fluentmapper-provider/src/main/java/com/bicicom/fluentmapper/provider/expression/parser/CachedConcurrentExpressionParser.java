package com.bicicom.fluentmapper.provider.expression.parser;

import com.bicicom.fluentmapper.expression.Expression;
import com.bicicom.fluentmapper.provider.core.loader.ModelClassloader;
import com.bicicom.fluentmapper.provider.expression.classextractor.ExpressionClassExtractor;
import com.bicicom.fluentmapper.provider.expression.classextractor.SingletonExpressionClassExtractor;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.invoke.SerializedLambda;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

/**
 * Expression parser for usage in a concurrent environment.
 */

public class CachedConcurrentExpressionParser extends ExpressionParser {
    private static final Logger logger = LoggerFactory.getLogger(CachedConcurrentExpressionParser.class);
    private final ConcurrentMap<String, Map<String, MethodNode>> classLambdas = new ConcurrentHashMap<>();

    public CachedConcurrentExpressionParser(ExpressionClassExtractor classExtractor) {
        super(classExtractor);
    }

    public static ExpressionParser withCachedExtractor() {
        return new CachedConcurrentExpressionParser(SingletonExpressionClassExtractor.instance());
    }

    static String getAccessedProperty(final MethodNode expression) throws ExpressionParseException {
        for (AbstractInsnNode instruction : expression.instructions) {
            if (instruction.getOpcode() == Opcodes.GETFIELD) {
                return ((FieldInsnNode) instruction).name;
            }
        }
        throw new ExpressionParseException("Could not parse expression. No field is returned by the parsed method " + expression.name);
    }

    @Override
    public ExpressionMetadata parse(Expression<?, ?> expression) {
        final SerializedLambda serializedLambda = toSerializedLambda(expression);

        final String containingClass = serializedLambda.getImplClass();
        final String lambdaSignature = serializedLambda.getImplMethodName();
        final MethodNode expressionLambda;

        if (classLambdas.get(containingClass) == null) {

            logger.trace("Caching expressions in {}", containingClass);
            // If not present in cache, read the class and cache its methods
            final ClassReader classReader;

            try {
                classReader = new ClassReader(
                        Objects.requireNonNull(ModelClassloader.instance().getClassloader().getResourceAsStream(
                                containingClass.replace('.', '/') + ".class"
                        ))
                );
            } catch (IOException e) {
                throw new ExpressionParseException("Unable to read class file for " + containingClass + ";", e);
            }

            final ClassNode node = new ClassNode();

            classReader.accept(node, 0);

            // Could go one step further and .filter() methods that start with 'lambda' but not worth it
            this.classLambdas.putIfAbsent(
                    containingClass,
                    node.methods.stream()
                            .collect(Collectors.toConcurrentMap(
                                    method -> method.name,
                                    methodNode -> methodNode
                            )));
        }

        expressionLambda = this.classLambdas.get(containingClass).get(lambdaSignature);

        final String accessedProperty = getAccessedProperty(expressionLambda);
        final String[] classes = classExtractor.extract(serializedLambda, accessedProperty);

        return new ExpressionMetadata(accessedProperty, classes[0], classes[1]);
    }

}
