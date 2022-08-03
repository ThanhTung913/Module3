package model;

public class Calculator {
    public static float calculator(float firstOperand, float secondOperand, char operator) {
        switch (operator) {
            case '+':
                return firstOperand + secondOperand;
            case '-':
                return firstOperand - secondOperand;
            case '*':
                return firstOperand * secondOperand;
            case '/':
                if (secondOperand != 0) {
                    return firstOperand / secondOperand;
                } else {
                    throw new RuntimeException("don't divate by zero");
                }

            default:
                throw new RuntimeException("Phép tính không hợp lệ");
        }
    }
}
