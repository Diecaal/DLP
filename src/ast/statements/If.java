package ast.statements;

import ast.Expression;
import ast.Statement;
import semantic.Visitor;

import javax.swing.plaf.nimbus.State;
import java.util.ArrayList;
import java.util.List;

public class If extends AbstractStatement {
    private List<Statement> statements_if;
    private List<Statement> statements_else;
    /* Condition */
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

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("if(" + getExpression() + ") {");
        getStatements_if().forEach(s -> sb.append("\n\t" + s));
        sb.append("\n}");
        if(getStatements_else().size() > 0) {
            sb.append(" else {");
            getStatements_else().forEach(s -> sb.append("\n\t" + s));
            sb.append("\n}");
        }
        return sb.toString();
    }
}
