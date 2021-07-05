package ast.expressions;

import ast.Expression;
import semantic.Visitor;

public class Logical extends AbstractExpression {
    private Expression leftExpression;
    private Expression rightExpression;
    private String operator;

    public Logical(int line, int column, Expression leftExpression, String operator, Expression rightExpression) {
        super(line, column);
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
        this.operator = operator;
    }

    public Expression getLeftExpression() {
        return leftExpression;
    }

    public Expression getRightExpression() {
        return rightExpression;
    }

    public String getOperator() {
        return operator;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", getLeftExpression(), getOperator(), getRightExpression());
    }
}
