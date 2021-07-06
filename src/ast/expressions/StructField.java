package ast.expressions;

import ast.Expression;
import semantic.Visitor;

public class StructField extends AbstractExpression {
    private Expression expression;
    private String field;

    public StructField(int line, int column, Expression expression, String field) {
        super(line, column);
        this.expression = expression;
        this.field = field;
    }

    public Expression getExpression() {
        return expression;
    }

    public String getField() {
        return field;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return getExpression() + "." + getField();
    }
}
