package ast.types;

import ast.ASTNode;
import ast.Type;
import semantic.Visitor;
import test.IntrospectorDemo;

public class IntType extends AbstractType {

    public IntType(int line, int column) {
        super(line, column);
        setNumberOfBytes(2);
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public Type checkValidAssignment(Type type, ASTNode ast) {
        if(type instanceof IntType){
            return new IntType(ast.getLine(),ast.getColumn());
        } else {
            return super.checkValidAssignment(type, ast); //Error behaviour
        }
    }

    @Override
    public Type arithmetic(Type type, ASTNode ast){
        if(type instanceof IntType){
            return new IntType(ast.getLine(), ast.getColumn());
        } else {
            return super.arithmetic(type, ast);
        }
    }

    @Override
    public Type comparison(Type type, ASTNode ast) {
        if(type instanceof IntType){
            return new IntType(ast.getLine(), ast.getColumn());
        } else {
            return super.comparison(type, ast);
        }
    }

    @Override
    public Type logical(Type type, ASTNode ast) {
        if(type instanceof IntType){
            return new IntType(ast.getLine(),ast.getColumn());
        } else {
            return super.logical(type, ast);
        }
    }

    @Override
    public Type checkValidMinus(ASTNode ast) {
        return new IntType(ast.getLine(), ast.getColumn());
    }

    @Override
    public Type checkValidNegation(ASTNode ast) {
        return new IntType(ast.getLine(), ast.getColumn());
    }

    @Override
    public boolean isBoolean(ASTNode ast) {
        return true;
    }

    @Override
    public String suffix() {
        return "i";
    }

    @Override
    public String[] convertTo(Type type) {
        if (type instanceof CharType) {
            return new String[] {"i2b"};
        } else if (type instanceof IntType) {
            return new String[] {};
        } else if (type instanceof DoubleType) {
            return new String[] {"i2f"};
        }
        return super.convertTo(type);
    }

    @Override
    public String toString(){
        return  "Integer";
    }
}
