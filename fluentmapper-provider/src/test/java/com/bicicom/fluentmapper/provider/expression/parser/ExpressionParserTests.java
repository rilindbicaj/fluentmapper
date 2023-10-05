package com.bicicom.fluentmapper.provider.expression.parser;

import com.bicicom.fluentmapper.expression.Expression;
import com.bicicom.fluentmapper.provider.testutils.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExpressionParserTests {

    private static final Expression<User, Integer> VALID_LAMBDA = (user) -> user.id;
    private static final Expression<User, Integer> VALID_METHOD_REFERENCE = User::getId;
    private static final Expression<User, String> INVALID_LAMBDA = (user) -> "invalid lambda";
    private static final Expression<User, String> INVALID_METHOD_REFERENCE = User::toString;

    private ExpressionParser parser;

    @BeforeEach
    public void reloadParser() {
        parser = CachedConcurrentExpressionParser.withExtractor();
    }

    @Test
    @DisplayName("Should successfully parse a valid lambda expression")
    public void givenValidLambdas_whenParsed_shouldParseSuccessfully() {
        var metadata = parser.parse(VALID_LAMBDA);

        assertNotNull(metadata);
    }

    @Test
    @DisplayName("Should correctly parse a valid lambda expression")
    public void givenValidLambda_whenParsed_shouldCorrectlyParseIt() {
        var metadata = parser.parse(VALID_LAMBDA);

        assertEquals("id", metadata.property());
        assertEquals(User.class.getName(), metadata.sourceClass());
        assertEquals(int.class.getName(), metadata.targetClass());
    }

    @Test
    @DisplayName("Should successfully parse a valid method reference")
    public void givenValidMethodReference_whenParsed_shouldSuccessfullyParseIt() {
        var metadata = parser.parse(VALID_METHOD_REFERENCE);

        assertNotNull(metadata);
    }

    @Test
    @DisplayName("Should correctly parse a valid method reference")
    public void givenValidMethodReference_whenParsed_shouldCorrectlyParseIt() {
        var metadata = parser.parse(VALID_METHOD_REFERENCE);

        assertEquals("id", metadata.property());
        assertEquals(User.class.getName(), metadata.sourceClass());
        assertEquals(int.class.getName(), metadata.targetClass());
    }

    @Test
    @DisplayName("Should throw exception when invalid lambda is parsed")
    public void givenInvalidLambda_whenParsed_shouldThrowParseException() {
        assertThrows(ExpressionParseException.class, () -> parser.parse(INVALID_LAMBDA));
    }

    @Test
    @DisplayName("Should throw exception when invalid method reference is parsed")
    public void givenInvalidMethodReference_whenParsed_shouldThrowParseException() {
        assertThrows(ExpressionParseException.class, () -> parser.parse(INVALID_METHOD_REFERENCE));
    }

    @Nested
    final class CachedConcurrentExpressionParserTests {

        private static final String NO_FIELD_RETURNED_MESSAGE = "No field access instruction found in method node ";

        private ExpressionParser parser;

        @BeforeEach
        public void reloadParser() {
            parser = CachedConcurrentExpressionParser.withExtractor();
        }

        @Test
        @DisplayName("Should throw parse exception when parsing lambda which does not return a field access")
        public void givenLambda_doesNotReturnField_shouldThrowParseException() {
            var exception = assertThrows(ExpressionParseException.class, () -> parser.parse(INVALID_LAMBDA));
            assertTrue(exception.getMessage().startsWith(NO_FIELD_RETURNED_MESSAGE));
        }

    }
}
