package ast.statements;

import ast.Expression;
import ast.Statement;

import java.util.ArrayList;
import java.util.List;

public class While extends AbstractStatement {
    private Expression expression;
    private List<Statement> statements;

    public While(int line, int column, Expression expression, List<Statement> statements) {
        super(line, column);
        this.expression = expression;
        this.statements = new ArrayList<Statement>(statements);
    }

    public Expression getExpression(){
        return this.expression;
    }

    public List<Statement> getStatements(){
        return this.statements;
    }
}
