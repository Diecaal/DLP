package ast.expressions;

import ast.Expression;
import semantic.Visitor;

public class RealLiteral extends AbstractExpression {
    private double value;

    public RealLiteral(int line, int column,double value) {
        super(line, column);
        this.value = value;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }
}
