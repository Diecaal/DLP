package ast.statements;

import ast.AbstractASTNode;
import ast.Expression;
import ast.Statement;

public class Assignment extends AbstractStatement {
    private Expression expressionLeft;
    private Expression expressionRight;

    public Assignment(int line, int column, Expression left, Expression right) {
        super(line, column);
        this.expressionLeft = left;
        this.expressionRight = right;
    }

    public Expression getLeft(){
        return expressionLeft;
    }

    public Expression getRight(){
        return expressionRight;
    }
}
