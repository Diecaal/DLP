package ast.expressions;

import ast.AbstractASTNode;
import ast.Expression;
import ast.Type;

public abstract class AbstractExpression extends AbstractASTNode implements Expression {
    boolean Lvalue;
    Type type;

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

    @Override
    public Type getType(){
        return this.type;
    }

    @Override
    public void setType(Type type){
        this.type = type;
    }
}
