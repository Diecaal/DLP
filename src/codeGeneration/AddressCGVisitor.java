package codeGeneration;

public class AddressCGVisitor {

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
        <muli>
        <addi>
 */