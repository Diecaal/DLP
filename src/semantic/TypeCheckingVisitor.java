package semantic;

import ast.*;
import ast.definitions.*;
import ast.expressions.*;
import ast.types.*;
import ast.statements.*;


public class TypeCheckingVisitor extends AbstractVisitor<Type,Type> {

    @Override
    public Type visit(Arithmetic ast, Type param) {
        super.visit(ast, param);
        ast.setLvalue( false );
        return null;
    }

    @Override
    public Type visit(Cast ast, Type param) {
        super.visit(ast, param);
        ast.setLvalue( false );
        return null;
    }

    @Override
    public Type visit(CharLiteral ast, Type param) {
        super.visit(ast, param);
        ast.setLvalue(false);
        return null;
    }

    @Override
    public Type visit(RealLiteral ast, Type param) {
        super.visit(ast, param);
        ast.setLvalue(false);
        return null;
    }

    @Override
    public Type visit(StructField ast, Type param) {
        super.visit(ast, param);
        ast.setLvalue(true);
        return null;
    }

    @Override
    public Type visit(ArrayIndex ast, Type param) {
        super.visit(ast, param);
        ast.setLvalue( true );
        return null;
    }

    @Override
    public Type visit(IntLiteral ast, Type param) {
        super.visit(ast, param);
        ast.setLvalue( false );
        return null;
    }

    @Override
    public Type visit(Logical ast, Type param) {
        super.visit(ast, param);
        ast.setLvalue( false );
        return null;
    }

    @Override
    public Type visit(UnaryMinus ast, Type param) {
        super.visit(ast, param);
        ast.setLvalue( false );
        return null;
    }

    @Override
    public Type visit(UnaryNegative ast, Type param) {
        super.visit(ast, param);
        ast.setLvalue( false );
        return null;
    }

    @Override
    public Type visit(Variable ast, Type param) {
        super.visit(ast, param);
        ast.setLvalue(true);
        return null;
    }

    @Override
    public Type visit(FunctionInvocation ast, Type param) {
        super.visit(ast, param);
        ast.setLvalue(false);
        return null;
    }

    /* Errors */
    @Override
    public Type visit(Assignment ast, Type param) {
        super.visit(ast, param);
        if ( !ast.getLeft().getLvalue() )
            new ErrorType(ast.getLine(), ast.getColumn(), "Lvalue expected");
        return null;
    }

    @Override
    public Type visit(Read ast, Type param) {
        super.visit(ast, param);
        if ( !ast.getExpression().getLvalue() )
            new ErrorType(ast.getLine(), ast.getColumn(), "Lvalue expected");
        return null;
    }

}
