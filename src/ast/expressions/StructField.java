package ast.expressions;

import ast.Expression;

public class StructField extends AbstractExpression {
    private Expression expression; //pair.integer -> allow integer to be expression
    private String field;

    public StructField(int line, int column, Expression expression, String field) {
        super(line, column);
        this.expression = expression;
        this.field = field;
    }
}
