package ast.expressions;

import ast.AbstractASTNode;
import ast.Expression;

public class AbstractExpression extends AbstractASTNode implements Expression {
    boolean Lvalue;

    public AbstractExpression(int line, int column) {
        super(line, column);
    }

    @Override
    public void setLvalue(boolean value) {
        this.Lvalue = value;
    }

    @Override
    public boolean getLvalue() {
        return this.Lvalue;
    }
}
