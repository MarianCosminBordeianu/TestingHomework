package org.example;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({CalculatorFirstTest.class, CalculatorSecondTest.class})
public class SuiteTest {
}
