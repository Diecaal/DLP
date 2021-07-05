package ast.statements;

import ast.Expression;
import ast.Statement;
import semantic.Visitor;

public class Write extends AbstractStatement {
    private Expression expression;

    public Write(int line, int column, Expression expression) {
        super(line, column);
        this.expression = expression;
    }

    public Expression getExpression(){
        return this.expression;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "write " + getExpression();
    }
}
