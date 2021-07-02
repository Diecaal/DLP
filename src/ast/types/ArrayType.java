package ast.types;

import ast.ASTNode;
import ast.Type;
import org.antlr.v4.codegen.model.ArgAction;
import semantic.Visitor;

import java.util.LinkedList;
import java.util.List;

public class ArrayType extends AbstractType {
    private Type type;
    private int length;

    public ArrayType(int line, int column, Type type, int length) {
        super(line, column);
        this.type = type;
        this.length = length;

        setNumberOfBytes( this.length * this.type.getNumberOfBytes() );
    }

    public Type getType(){
        return this.type;
    }

    public int getLength(){
        return this.length;
    }

    public static ArrayType createArray(int line, int column, Type type, int length){
        if (type instanceof ArrayType) { // Continue
            ArrayType toCheck = ((ArrayType) type);
            return toCheck.createArraySubType(line, column, type, length);
        } else { // Default brk
            return new ArrayType(line, column, type, length);
        }
    }

    private ArrayType createArraySubType(int line, int column, Type type, int length) {
        ArrayType checked = null;
        if (type instanceof ArrayType) { // Continue
            checked = ((ArrayType) type).createArraySubType(line, column, this.type, length);
        } else { // Default brk
            this.type = new ArrayType(line,column, this.type, length);
            checked = (ArrayType) this.type;
        }
        return this; //end execution - return type handled
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public Type checkValidAssignment(Type type, ASTNode ast) {
        if(type instanceof ArrayType){
            Type arrayType = ((ArrayType)type).getType();
            int arrayLength = ((ArrayType)type).getLength();
            return new ArrayType(ast.getLine(),ast.getColumn(),arrayType,arrayLength);
        } else {
            return super.checkValidAssignment(type, ast); //Error behaviour
        }
    }

    @Override
    public Type squareBrackets(Type paramType, ASTNode ast) {
        if(paramType instanceof IntType){ //Valid value for indexing
            return this.type;
        }

        return super.squareBrackets(paramType, ast);
    }

    @Override
    public String toString(){
        return  "Array, type:"+getType()+", length:"+getLength();
    }
}