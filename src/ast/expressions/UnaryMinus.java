package ast.expressions;

import ast.Expression;

public class UnaryMinus extends AbstractExpression {
    private Expression expression;

    public UnaryMinus(int line, int column, Expression expression) {
        super(line, column);
        this.expression = expression;
    }
}
