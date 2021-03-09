package ast.expressions;

import ast.Expression;

public class Logical extends AbstractExpression {
    private Expression leftExpression;
    private Expression rightExpression;
    private String operator;

    public Logical(int line, int column, Expression leftExpression, String operator, Expression rightExpression) {
        super(line, column);
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
        this.operator = operator;
    }
}
