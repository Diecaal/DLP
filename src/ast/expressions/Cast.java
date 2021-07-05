package ast.expressions;

import ast.Expression;
import ast.Type;
import semantic.Visitor;

public class Cast extends AbstractExpression {
    private Expression expression;
    private Type typeCast;

    public Cast(int line, int column, Type typeCast, Expression expression) {
        super(line, column);
        this.expression = expression;
        this.typeCast = typeCast;
    }

    public Expression getExpression() {
        return expression;
    }

    public Type getTypeCast() {
        return typeCast;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return String.format("(%s) %s", getTypeCast(), getExpression());
    }
}
