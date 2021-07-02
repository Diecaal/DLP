package ast.statements;

import ast.Expression;
import ast.Type;
import ast.expressions.AbstractExpression;
import ast.expressions.Variable;
import ast.statements.AbstractStatement;
import semantic.Visitor;

import java.util.ArrayList;
import java.util.List;

public class FunctionInvocation extends AbstractStatement implements Expression {
    /* Parameters */
    private List<Expression> expressions;
    private Variable variable;
    private boolean Lvalue;
    private Type type;

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

    @Override
    public void setLvalue(boolean value) {
        this.Lvalue = value;
    }

    @Override
    public boolean getLvalue() {
        return this.Lvalue;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }
}
