package ast.statements;

import ast.Expression;
import ast.Statement;
import semantic.Visitor;

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

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("while( ");
        sb.append(getExpression() + ") {");
        getStatements().forEach(statement -> sb.append("\n" + statement));
        sb.append("\n}");
        return sb.toString();
    }
}
