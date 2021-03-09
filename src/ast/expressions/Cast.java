package ast.expressions;

import ast.Expression;
import ast.Type;

public class Cast extends AbstractExpression {
    private Expression expression;
    private Type typeCast;

    public Cast(int line, int column, Type typeCast, Expression expression) {
        super(line, column);
        this.expression = expression;
        this.typeCast = typeCast;
    }
}
