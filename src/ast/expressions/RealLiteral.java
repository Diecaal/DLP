package ast.expressions;

import ast.Expression;

public class RealLiteral extends AbstractExpression {
    private double value;

    public RealLiteral(int line, int column,double value) {
        super(line, column);
        this.value = value;
    }
}
