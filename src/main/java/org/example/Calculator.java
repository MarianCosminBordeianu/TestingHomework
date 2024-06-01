package org.example;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private String expression;
    private String [] operands;
    private String [] operators;
    private Scales minScale;

    public Calculator(String expression){
        this.expression = expression;
        this.operands = expression.split("[+-]");
        this.operators = extractOperators(expression);

    }

    private String[] extractOperators(String expression) {
        List<String> operatorsList = new ArrayList<>();
        for (char ch : expression.toCharArray()) {
            if (ch == '+' || ch == '-') {
                operatorsList.add(String.valueOf(ch));
            }
        }
        return operatorsList.toArray(new String[0]);
    }
    private int transformDistance(String operand){
        String []splits = operand.trim().split("\\s+");
        if(splits.length != 2){
            throw new IllegalArgumentException("Invalid operand: " + operand);
        }

        Scales scale;
        try {
              scale = Scales.valueOf(splits[1].toUpperCase());
              updateMinScale(scale);
        }catch (Exception e) {
            throw new IllegalArgumentException("Unknown unit: " + splits[1],e);
        }
        return Integer.parseInt(splits[0]) * scale.getValue();
    }

    private void updateMinScale(Scales scale) {
        if(minScale == null || minScale.getValue() > scale.getValue()){
            minScale = scale;
        }
    }

    public int calculate(){
        int result=0;
        for (int i = 0; i < operands.length - 1; i++) {
            if (operands[0].isEmpty()){
                if (operators[i].equals("+")){
                    result += transformDistance(operands[i + 1].trim());
                }
                else {
                    result -= transformDistance(operands[i + 1].trim());
                }
            }
            else{
                result = transformDistance(operands[0].trim());
                if (operators[i].equals("-")){
                    result -= transformDistance(operands[i +  1].trim());
                }
                else {
                    result += transformDistance(operands[i +  1].trim());
                }
            }
        }
        if (minScale != Scales.MM){
            return result / minScale.getValue();
        }
        return result;
    }

    public String getExpression() {
        return expression;
    }

    public String[] getOperands() {
        return operands;
    }

    public void setOperands(String[] operands) {
        this.operands = operands;
    }

    public String[] getOperators() {
        return operators;
    }

    public Scales getMinScale() {
        return minScale;
    }

    public void setOperators(String[] operators) {
        this.operators = operators;
    }

    public void setExpression(String expression) {
        this.expression = expression;
        this.operands = expression.split("[+-]");
        this.operators = extractOperators(expression);
    }
}
