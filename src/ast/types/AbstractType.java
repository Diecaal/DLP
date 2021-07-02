package ast.types;

import ast.ASTNode;
import ast.AbstractASTNode;
import ast.Expression;
import ast.Type;

import java.util.List;

public abstract class AbstractType extends AbstractASTNode implements Type {

    private int numberOfBytes = 0;

    public AbstractType(int line, int column) {
        super(line, column);
    }

    @Override
    public Type checkValidAssignment(Type type, ASTNode ast){
        String msg = "Cannot assign " + this.toString() + " type to " + type.toString() + " type";
        return new ErrorType(ast.getLine(), ast.getColumn(),msg);
    }

    @Override
    public Type arithmetic(Type type, ASTNode ast) {
        String msg = "Can't apply arithmetic operation between " + this.toString() + " and " +  type.toString();
        return new ErrorType(ast.getLine(), ast.getColumn(), msg);
    }

    @Override
    public Type comparison(Type type, ASTNode ast) {
        String msg = "Can't apply comparison operation between " + this.toString() + " and " +  type.toString();
        return new ErrorType(ast.getLine(), ast.getColumn(), msg);
    }

    @Override
    public Type logical(Type type, ASTNode ast) {
        String msg = "Can't apply logical operation between " + this.toString() + " and " +  type.toString();
        return new ErrorType(ast.getLine(), ast.getColumn(), msg);
    }

    @Override
    public Type dot(String Id, ASTNode ast) {
        String msg = "Can't access field " + Id + " of " +  this.toString();
        return new ErrorType(ast.getLine(), ast.getColumn(), msg);
    }

    @Override
    public Type squareBrackets(Type type, ASTNode ast) {
        String msg = "Can't perform index between " + this.toString() + " and " +  type.toString();
        return new ErrorType(ast.getLine(), ast.getColumn(), msg);
    }

    @Override
    public Type checkValidMinus(ASTNode ast) {
        String msg = "Can't apply '-' operator to " + this.toString();
        return new ErrorType(ast.getLine(), ast.getColumn(), msg);
    }

    @Override
    public Type checkValidInvoke(List<Expression> params, ASTNode ast) {
        String msg = "Can't invoke " + this.toString();
        return new ErrorType(ast.getLine(), ast.getColumn(), msg);
    }

    @Override
    public Type checkValidNegation(ASTNode ast) {
        String msg = "Can't apply '!' operator to " + this.toString();
        return new ErrorType(ast.getLine(), ast.getColumn(), msg);
    }

    @Override
    public boolean isBoolean(ASTNode ast) {
        return false;
    }

    @Override
    public String suffix() {
        return null;
    }

    @Override
    public int getNumberOfBytes() {
        return numberOfBytes;
    }

    public void setNumberOfBytes(int numberOfBytes) {
        this.numberOfBytes = numberOfBytes;
    }

    @Override
    public String[] convertTo(Type to) {
        throw new RuntimeException("Convert " + this.toString() + " to " + to.toString() + " not allowed");
    }

}