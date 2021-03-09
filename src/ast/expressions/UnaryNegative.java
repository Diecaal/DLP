package ast.expressions;

import ast.Expression;

public class UnaryNegative extends AbstractExpression {
    private Expression expression;

    public UnaryNegative(int line, int column, Expression expression) {
        super(line, column);
        this.expression = expression;
    }
}
