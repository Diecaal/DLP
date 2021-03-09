package ast.statements;

import ast.Expression;
import ast.Statement;

import javax.swing.plaf.nimbus.State;
import java.util.ArrayList;
import java.util.List;

public class If extends AbstractStatement {
    private List<Statement> statements_if;
    private List<Statement> statements_else;
    private Expression expression;

    public If(int line, int column, Expression expression, List<Statement> statements_if, List<Statement> statements_else) {
        super(line, column);
        this.statements_if = new ArrayList<Statement>(statements_if);
        this.statements_else = new ArrayList<Statement>(statements_else);
        this.expression = expression;
    }

    public Expression getExpression(){
        return this.expression;
    }

    public List<Statement> getStatements_if(){
        return statements_if;
    }

    public List<Statement> getStatements_else(){
        return statements_else;
    }
}
