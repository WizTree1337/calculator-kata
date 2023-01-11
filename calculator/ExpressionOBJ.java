package calculator;

public class ExpressionOBJ {
    int firstOperand;
    int secondOperand;
    String operator;
    TypeOfExpression type;

    public ExpressionOBJ(int firstOperand, int secondOperand, String operator, TypeOfExpression type){
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
        this.operator = operator;
        this.type = type;
    }

}
