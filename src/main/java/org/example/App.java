package org.example;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println( "Insert the expression: " );
        String expression = scanner.nextLine();
        Calculator calculator = new Calculator(expression);
        System.out.println(Arrays.toString(calculator.getOperands()));
        System.out.println(Arrays.toString(calculator.getOperators()));
        System.out.println("Expresion: " + expression + " = " + calculator.calculate() + calculator.getMinScale());

    }
}
