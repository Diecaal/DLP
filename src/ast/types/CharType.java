package ast.types;

import ast.ASTNode;
import ast.Type;
import semantic.Visitor;

public class CharType extends AbstractType {

    public CharType(int line, int column) {
        super(line, column);
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public Type checkValidAssignment(Type type, ASTNode ast) {
        if(type instanceof CharType){
            return new CharType(ast.getLine(),ast.getColumn());
        } else {
            return super.checkValidAssignment(type, ast); //Error behaviour
        }
    }

    @Override
    public Type arithmetic(Type type, ASTNode ast) {
        if (type instanceof CharType) {
            return new CharType(ast.getLine(), ast.getColumn());
        } else {
            return super.arithmetic(type, ast);
        }
    }

    @Override
    public Type comparison(Type type, ASTNode ast) {
        if (type instanceof CharType) {
            return new CharType(ast.getLine(), ast.getColumn());
        } else if (type instanceof IntType) {
            return new IntType(ast.getLine(), ast.getColumn());
        } else {
            return super.comparison(type, ast);
        }
    }

    @Override
    public String toString(){
        return "Char";
    }
}