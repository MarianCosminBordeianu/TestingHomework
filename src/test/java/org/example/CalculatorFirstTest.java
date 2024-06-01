package org.example;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CalculatorFirstTest
{
    @ParameterizedTest
    @ValueSource(strings = {"2 cm + 3 dm"})
    public void CalculatorTest(String expression){
        Calculator calculator = new Calculator(expression);
        assertEquals(32,
                calculator.calculate());
    }
}
