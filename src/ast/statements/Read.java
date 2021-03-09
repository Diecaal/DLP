package ast.statements;

import ast.Expression;
import ast.Statement;

public class Read extends AbstractStatement {
    private Expression expression;

    public Read(int line, int column, Expression expression) {
        super(line, column);
        this.expression = expression;
    }

    public Expression getExpression(){
        return this.expression;
    }
}
