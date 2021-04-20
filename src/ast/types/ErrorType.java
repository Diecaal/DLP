package ast.types;

import ast.ASTNode;
import ast.Expression;
import ast.Type;
import error.ErrorHandler;
import semantic.Visitor;

import java.util.List;

public class ErrorType extends AbstractType {
    private String message;

    public ErrorType(int line, int column, String message) {
        super(line, column);
        this.message = message;
        ErrorHandler.getInstance().newError(this);
    }

    public String getMessage(){
        return this.message;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public Type checkValidAssignment(Type type, ASTNode ast) {
        return this;
    }

    @Override
    public Type arithmetic(Type type, ASTNode ast) {
        return this;
    }

    @Override
    public Type comparison(Type type, ASTNode ast) {
        return this;
    }

    @Override
    public Type dot(String Id, ASTNode ast) {
        return this;
    }

    @Override
    public Type squareBrackets(Type type, ASTNode ast) {
        return this;
    }

    @Override
    public Type checkValidMinus(ASTNode ast) {
        return this;
    }

    @Override
    public Type checkValidInvoke(List<Expression> params, ASTNode ast) {
        return this;
    }

    @Override
    public Type checkValidNegation(ASTNode ast) {
        return this;
    }

    @Override
    public boolean isBoolean(ASTNode ast) {
        return false;
    }

    @Override
    public String toString(){
        return "Error [line:"+getLine()+",column:"+getColumn()+"] : " + getMessage();
    }
}
