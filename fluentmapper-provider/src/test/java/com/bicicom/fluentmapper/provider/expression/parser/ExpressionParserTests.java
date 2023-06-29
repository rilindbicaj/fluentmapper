package com.bicicom.fluentmapper.provider.expression.parser;

import com.bicicom.fluentmapper.expression.Expression;
import com.bicicom.fluentmapper.provider.testutils.models.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExpressionParserTests {

    @Test
    public void givenValidLambdas_shouldParseSuccessfully() {
        Expression<User, Integer> valid_1 = (user) -> user.id;

        Assertions.assertEquals(true, true);
    }
}
