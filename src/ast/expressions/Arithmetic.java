package ast.expressions;

import ast.Expression;

public class Arithmetic extends AbstractExpression {
    private String operator;
    private Expression leftExpression;
    private Expression rightExpression;

    public Arithmetic(int line, int column, Expression leftExpression,  String operator, Expression rightExpression) {
        super(line, column);
        this.operator = operator;
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }
}
