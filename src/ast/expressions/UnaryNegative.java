package ast.expressions;

import ast.Expression;
import semantic.Visitor;

public class UnaryNegative extends AbstractExpression {
    private Expression expression;

    public UnaryNegative(int line, int column, Expression expression) {
        super(line, column);
        this.expression = expression;
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "!" + getExpression();
    }
}
