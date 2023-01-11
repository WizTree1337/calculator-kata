package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Calculator {
    public static String calc(ExpressionOBJ expression) throws ThrowsException {
        int res = switch (expression.operator) {
            case "+" -> expression.firstOperand + expression.secondOperand;
            case "-" -> expression.firstOperand - expression.secondOperand;
            case "*" -> expression.firstOperand * expression.secondOperand;
            case "/" -> (int) (expression.firstOperand / expression.secondOperand);
            default -> 0;
        };
        if (expression.type == TypeOfExpression.ARABIC) {
            return Integer.toString(res);
        }
        else if (res <= 0) {
            throw new ThrowsException("т.к. в римской системе нет отрицательных чисел");
        }
        else {
            return Convertation.arabicToRoman(res);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String input;
            String output;
            if (!(input = br.readLine().toUpperCase()).equals("")) {
                try {
                    ExpressionOBJ expr = ExceptionCheck.parse(input);
                    output = Calculator.calc(expr);
                    System.out.println(output);
                }
                catch (ThrowsException e) {
                    System.out.println(e);
                }
            }
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
