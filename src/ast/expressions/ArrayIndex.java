package ast.expressions;

import ast.Expression;

public class ArrayIndex extends AbstractExpression {
    private Expression array;
    private Expression index;

    public ArrayIndex(int line, int column,Expression array,Expression index) {
        super(line, column);
        this.array = array;
        this.index = index;
    }
}
