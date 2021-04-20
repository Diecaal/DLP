package semantic;

import ast.*;
import ast.types.*;
import ast.expressions.*;
import ast.statements.*;
import ast.definitions.*;

public abstract class AbstractVisitor<TP,TR> implements Visitor<TP,TR> {

    @Override
    public TR visit(Program ast, TP param) {
        for(Definition def : ast.getDefinitions())
            def.accept(this, param);
        return null;
    }

    @Override
    public TR visit(Arithmetic ast, TP param) {
        ast.getLeftExpression().accept(this, param);
        ast.getRightExpression().accept(this, param);
        return null;
    }

    @Override
    public TR visit(Relational ast, TP param) {
        ast.getLeftExpression().accept(this, param);
        ast.getRightExpression().accept(this, param);
        return null;
    }

    @Override
    public TR visit(ArrayIndex ast, TP param) {
        ast.getArray().accept(this, param);
        ast.getIndex().accept(this, param);
        return null;
    }

    @Override
    public TR visit(Cast ast, TP param) {
        ast.getExpression().accept(this, param);
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
        ast.getLeftExpression().accept(this, param);
        ast.getRightExpression().accept(this, param);
        return null;
    }

    @Override
    public TR visit(RealLiteral ast, TP param) {
        return null;
    }

    @Override
    public TR visit(StructField ast, TP param) {
        ast.getExpression().accept(this, param);
        return null;
    }

    @Override
    public TR visit(UnaryNegative ast, TP param) {
        ast.getExpression().accept(this, param);
        return null;
    }

    @Override
    public TR visit(UnaryMinus ast, TP param) {
        ast.getExpression().accept(this, param);
        return null;
    }

    @Override
    public TR visit(Variable ast, TP param) {
        return null;
    }

    @Override
    public TR visit(Assignment ast, TP param) {
        ast.getLeft().accept(this, param);
        ast.getRight().accept(this, param);
        return null;
    }

    @Override
    public TR visit(FunctionInvocation ast, TP param) {
        ast.getVariable().accept(this, param);
        for(Expression e:ast.getExpressions())
            e.accept(this, param);
        return null;
    }

    @Override
    public TR visit(If ast, TP param) {
        ast.getExpression().accept(this, param);
        for(Statement s:ast.getStatements_if())
            s.accept(this, param);
        for(Statement s:ast.getStatements_else())
            s.accept(this, param);
        return null;
    }

    @Override
    public TR visit(Read ast, TP param) {
        ast.getExpression().accept(this, param);
        return null;
    }

    @Override
    public TR visit(Return ast, TP param) {
        ast.getExpression().accept(this, param);
        return null;
    }

    @Override
    public TR visit(While ast, TP param) {
        ast.getExpression().accept(this, param);
        for(Statement s:ast.getStatements())
            s.accept(this, param);
        return null;
    }

    @Override
    public TR visit(Write ast, TP param) {
        ast.getExpression().accept(this, param);
        return null;
    }

    @Override
    public TR visit(ArrayType ast, TP param) {
        ast.getType().accept(this, param);
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
        ast.getType().accept(this, param);
        for(VariableDefinition v:ast.getParameters())
            v.accept(this, param);
        return null;
    }

    @Override
    public TR visit(IntType ast, TP param) {
        return null;
    }

    @Override
    public TR visit(RecordField ast, TP param) {
        ast.getType().accept(this, param);
        return null;
    }

    @Override
    public TR visit(StructType ast, TP param) {
        for(RecordField r:ast.getRecordFields())
            r.accept(this, param);
        return null;
    }

    @Override
    public TR visit(VoidType ast, TP param) {
        return null;
    }

    @Override
    public TR visit(FunctionDefinition ast, TP param) {
        ast.getType().accept(this, param);
        for(Statement s:ast.getStatements())
            s.accept(this, param);
        return null;
    }

    @Override
    public TR visit(VariableDefinition ast, TP param) {
        ast.getType().accept(this, param);
        return null;
    }
}
