package ast.statements;

import ast.Expression;
import ast.expressions.AbstractExpression;
import ast.expressions.Variable;
import ast.statements.AbstractStatement;

import java.util.ArrayList;
import java.util.List;

public class FunctionInvocation extends AbstractStatement implements Expression {
    private List<Expression> expressions;
    private Variable variable;

    public FunctionInvocation(int line, int column, List<Expression> expressions, Variable variable) {
        super(line, column);
        this.expressions = new ArrayList<Expression>(expressions);
        this.variable = variable;
    }

    public List<Expression> getExpressions(){
        return new ArrayList<Expression>(this.expressions);
    }

    public Variable getVariable(){
        return this.variable;
    }
}
