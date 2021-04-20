package ast.statements;

import ast.AbstractASTNode;
import ast.Expression;
import ast.Statement;
import semantic.Visitor;

public class Assignment extends AbstractStatement {
    private Expression expressionLeft;
    private Expression expressionRight;

    public Assignment(int line, int column, Expression left, Expression right) {
        super(line, column);
        this.expressionLeft = left;
        this.expressionRight = right;
    }

    public Expression getLeft(){
        return this.expressionLeft;
    }

    public Expression getRight(){
        return this.expressionRight;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }
}
