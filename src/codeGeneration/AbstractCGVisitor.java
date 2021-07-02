package codeGeneration;

import ast.Program;
import ast.definitions.*;
import ast.expressions.*;
import ast.statements.*;
import ast.types.*;
import semantic.AbstractVisitor;

public abstract class AbstractCGVisitor<TP,TR> extends AbstractVisitor<TP,TR> {
    public CodeGenerator cg = new CodeGenerator();
    public ValueCGVisitor value = null;
    public AddressCGVisitor address = null;
    public ExecuteCGVisitor execute = null;

    @Override
    public TR visit(Program ast, TP param) {
        return null;
    }

    @Override
    public TR visit(Arithmetic ast, TP param) {
        return null;
    }

    @Override
    public TR visit(Relational ast, TP param) {
        return null;
    }

    @Override
    public TR visit(ArrayIndex ast, TP param) {
        return null;
    }

    @Override
    public TR visit(Cast ast, TP param) {
        return null;
    }

    @Override
    public TR visit(CharLiteral ast, TP param) {
        return null;
    }

    @Override
    public TR visit(IntLiteral ast, TP param) {
        return null;
    }

    @Override
    public TR visit(Logical ast, TP param) {
        return null;
    }

    @Override
    public TR visit(RealLiteral ast, TP param) {
        return null;
    }

    @Override
    public TR visit(StructField ast, TP param) {
        return null;
    }

    @Override
    public TR visit(UnaryNegative ast, TP param) {
        return null;
    }

    @Override
    public TR visit(UnaryMinus ast, TP param) {
        return null;
    }

    @Override
    public TR visit(Variable ast, TP param) {
        return null;
    }

    @Override
    public TR visit(Assignment ast, TP param) {
        return null;
    }

    @Override
    public TR visit(FunctionInvocation ast, TP param) {
        return null;
    }

    @Override
    public TR visit(If ast, TP param) {
        return null;
    }

    @Override
    public TR visit(Read ast, TP param) {
        return null;
    }

    @Override
    public TR visit(Return ast, TP param) {
        return null;
    }

    @Override
    public TR visit(While ast, TP param) {
        return null;
    }

    @Override
    public TR visit(Write ast, TP param) {
        return null;
    }

    @Override
    public TR visit(ArrayType ast, TP param) {
        return null;
    }

    @Override
    public TR visit(CharType ast, TP param) {
        return null;
    }

    @Override
    public TR visit(DoubleType ast, TP param) {
        return null;
    }

    @Override
    public TR visit(ErrorType ast, TP param) {
        return null;
    }

    @Override
    public TR visit(FunctionType ast, TP param) {
        return null;
    }

    @Override
    public TR visit(IntType ast, TP param) {
        return null;
    }

    @Override
    public TR visit(RecordField ast, TP param) {
        return null;
    }

    @Override
    public TR visit(StructType ast, TP param) {
        return null;
    }

    @Override
    public TR visit(VoidType ast, TP param) {
        return null;
    }

    @Override
    public TR visit(FunctionDefinition ast, TP param) {
        return null;
    }

    @Override
    public TR visit(VariableDefinition ast, TP param) {
        return null;
    }
}
