package calculator;

import java.util.Arrays;
import java.util.List;

public class ExceptionCheck {

    private static final List<String> operators = Arrays.asList("+", "-", "*", "/");
    private static final List<String> allowedArabic = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
    private static final List<String> allowedRoman = Arrays.asList("I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X");
    public static ExpressionOBJ parse(String input) throws ThrowsException {
        String[] splicedInput = input.split(" ");
        ExpressionOBJ expression;

        if (splicedInput.length != 3){
            throw new ThrowsException("т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        else if (!operators.contains(splicedInput[1])) {
            throw new ThrowsException("т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        else if ((!allowedArabic.contains(splicedInput[0]) && !allowedRoman.contains(splicedInput[0])) ||
                (!allowedArabic.contains(splicedInput[2]) && !allowedRoman.contains(splicedInput[2]))){
            throw new ThrowsException("т.к. одно из чисел больше 10");
        }
        else if ((allowedArabic.contains(splicedInput[0]) && allowedRoman.contains(splicedInput[2])) ||
                (allowedArabic.contains(splicedInput[2]) && allowedRoman.contains(splicedInput[0]))){
            throw new ThrowsException("т.к. используются одновременно разные системы счисления");
        }
        else if (allowedArabic.contains(splicedInput[0])){
            expression = new ExpressionOBJ(allowedArabic.indexOf(splicedInput[0]) + 1,
                    allowedArabic.indexOf(splicedInput[2]) + 1, splicedInput[1], TypeOfExpression.ARABIC);
        }
        else {
            expression = new ExpressionOBJ(allowedRoman.indexOf(splicedInput[0]) + 1,
                    allowedRoman.indexOf(splicedInput[2]) + 1, splicedInput[1], TypeOfExpression.ROMAN);
        }
        return expression;
    }

}
