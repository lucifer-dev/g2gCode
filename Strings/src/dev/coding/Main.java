package dev.coding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Map<Character, Integer> operatorPrecedence = new HashMap<>();
        operatorPrecedence.put('$', 3);
        operatorPrecedence.put('*', 2);
        operatorPrecedence.put('/', 2);
        operatorPrecedence.put('+', 1);
        operatorPrecedence.put('-', 1);
        String inputExpression = "65+23-45*2/9+234-2324/98-3156";
        Stack<Character> operatorStack = new Stack<>();
        ArrayList<String> postFixExpression = new ArrayList<>();
        for (int index = 0; index < inputExpression.length(); index++) {
            if (Character.isDigit(inputExpression.charAt(index))) {
                int integerStartIndex = index;
                while (index + 1 < inputExpression.length() && Character.isDigit(inputExpression.charAt(index + 1))) {
                    index = index + 1;
                }
                postFixExpression.add(inputExpression.substring(integerStartIndex, index + 1));
            } else if (!Character.isDigit(inputExpression.charAt(index))) {
                if (operatorStack.isEmpty() || operatorPrecedence.get(operatorStack.peek()) < operatorPrecedence.get(inputExpression
                        .charAt(index))) {
                    operatorStack.push(inputExpression.charAt(index));
                } else {
                    while (!operatorStack.isEmpty() && operatorPrecedence.get(operatorStack.peek()) >= operatorPrecedence.get
                            (inputExpression
                                    .charAt(index))) {
                        postFixExpression.add(String.valueOf(operatorStack.pop()));
                    }
                    operatorStack.push(inputExpression.charAt(index));
                }
            }
        }
        while (!operatorStack.isEmpty()) {
            postFixExpression.add(String.valueOf(operatorStack.pop()));
        }
        System.out.println("Post fix expression : " + postFixExpression);
        System.out.println("Expression output : " + evaluatePostfixExpression(postFixExpression));
    }

    private static int evaluatePostfixExpression(ArrayList<String> postFixExpression) {
        Stack<Integer> evaluationStack = new Stack<>();
        for (String token : postFixExpression) {
            if (Character.isDigit(token.charAt(0))) {
                evaluationStack.push(Integer.parseInt(token));
            } else {
                evaluationStack.push(performNumberCalculation(token, evaluationStack.pop(), evaluationStack.pop()));
            }
        }
        return evaluationStack.pop();
    }

    private static int performNumberCalculation(String operator, int operandOne, int operandTwo) {
        int result = -1;
        switch (operator) {
            case "+": {
                result = (operandOne + operandTwo);
                break;
            }
            case "-": {
                result = (operandTwo - operandOne);
                break;
            }
            case "*": {
                result = (operandOne * operandTwo);
                break;
            }
            case "/": {
                result = (operandTwo / operandOne);
                break;
            }
        }
        return result;
    }
}
