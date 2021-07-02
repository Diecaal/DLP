package codeGeneration;

import ast.definitions.VariableDefinition;
import ast.expressions.ArrayIndex;
import ast.expressions.StructField;
import ast.expressions.Variable;
import ast.types.RecordField;
import ast.types.StructType;

public class AddressCGVisitor extends AbstractCGVisitor<Void,Void> {

    @Override
    public Void visit(ArrayIndex ast, Void param) {
        ast.getArray().accept(address, param);
        ast.getIndex().accept(value, param);
        cg.writeInstruction("pushi \t" + ast.getType().getNumberOfBytes());
        cg.writeInstruction("muli");
        cg.writeInstruction("addi");
        return super.visit(ast, param);
    }

    @Override
    public Void visit(StructField ast, Void param) {
        ast.getExpression().accept(address, param);
        /* Search the offset of provided field in the struct */
        cg.writeInstruction("pushi\t" + ((StructType) ast.getExpression().getType()).getField(ast.getField()).getOffset() );
        cg.writeInstruction("addi");
        return null;
    }

    @Override
    public Void visit(Variable ast, Void param) {
        if(ast.getDefinition().getScope() == 0){
            cg.writeInstruction("pusha \t" + ((VariableDefinition)ast.getDefinition()).getOffset());
        } else {
            cg.writeInstruction("push \t bp");
            cg.writeInstruction("pushi\t" + ((VariableDefinition) ast.getDefinition()).getOffset());
            cg.writeInstruction("addi");
        }
        return super.visit(ast, param);
    }
}

/*
    address[[Variable: exp -> ID]] =
        if (exp.definition.scope==0)
            <pusha> exp.definition.offset
        else {
            <push bp>
            <pushi> exp.definition.offset
            <addi>
        }

    address[StructField: expression1 -> expression2 ID] =
        address[[expression2]]
        <pushi> expression2.type.getField(ID).offset
        <addi>

     address[[Indexing: expression1 -> expression2 expression3]] =
        address[[expression2]]
        value[[expression3]]
        <pushi > expression1.type.numberOfBytes()
        <muli> //Multiplying x times the number of bytes in <pushi>
        <addi>

 */