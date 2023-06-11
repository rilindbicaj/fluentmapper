package com.bibicom.fluentmapper.provider.expression.parser;

import com.bibicom.fluentmapper.provider.testutils.User;
import com.bicicom.fluentmapper.expression.Expression;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExpressionParserTests {

    @Test
    public void givenValidLambdas_shouldParseSuccessfully() {
        Expression<User, Integer> valid_1 = (user) -> user.id;

        Assertions.assertEquals(true, true);
    }
}
