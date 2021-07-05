package ast.expressions;

import ast.Expression;
import semantic.Visitor;

public class ArrayIndex extends AbstractExpression {
    private Expression array;
    private Expression index;

    public ArrayIndex(int line, int column,Expression array,Expression index) {
        super(line, column);
        this.array = array;
        this.index = index;
    }

    public Expression getArray() {
        return array;
    }

    public Expression getIndex() {
        return index;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return getArray() + "[" + getIndex() + "]";
    }

}
