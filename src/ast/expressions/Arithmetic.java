package ast.expressions;

import ast.Expression;
import semantic.Visitor;

public class Arithmetic extends AbstractExpression {
    private String operator;
    private Expression leftExpression;
    private Expression rightExpression;

    public Arithmetic(int line, int column, Expression leftExpression,  String operator, Expression rightExpression) {
        super(line, column);
        this.operator = operator;
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    public Expression getLeftExpression(){
        return this.leftExpression;
    }

    public Expression getRightExpression(){
        return this.rightExpression;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }
}