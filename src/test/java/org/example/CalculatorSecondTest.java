package org.example;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorSecondTest
{
    @ParameterizedTest
    @ValueSource(strings = {"- 10 cm + 3 dm"})
    public void calculatorTest(String expression){
        Calculator calculator = new Calculator(expression);
        assertEquals(20,
                calculator.calculate());
    }
}
