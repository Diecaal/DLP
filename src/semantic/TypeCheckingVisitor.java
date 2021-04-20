package semantic;

import ast.*;
import ast.definitions.*;
import ast.expressions.*;
import ast.types.*;
import ast.statements.*;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.RealType;

public class TypeCheckingVisitor extends AbstractVisitor<Type,Type> {

    @Override
    public Type visit(Arithmetic ast, Type param) {
        super.visit(ast, param);
        ast.setLvalue( false );
        //Define resulting expression type
        Type left = ast.getLeftExpression().getType();
        Type right = ast.getRightExpression().getType();
        ast.setType(left.arithmetic(right, ast));
        return null;
    }

    @Override
    public Type visit(Relational ast, Type param) {
        super.visit(ast, param);
        ast.setLvalue( false );
        //Define resulting expression type
        Type left = ast.getLeftExpression().getType();
        Type right = ast.getRightExpression().getType();
        ast.setType(left.comparison(right, ast));
        return null;
    }

    @Override
    public Type visit(Cast ast, Type param) {
        super.visit(ast, param);
        ast.setLvalue( false );
        ast.setType(ast.getTypeCast());
        return null;
    }

    @Override
    public Type visit(CharLiteral ast, Type param) {
        super.visit(ast, param);
        ast.setLvalue(false);
        ast.setType( new CharType(ast.getLine(), ast.getColumn()) );
        return null;
    }

    @Override
    public Type visit(RealLiteral ast, Type param) {
        super.visit(ast, param);
        ast.setLvalue(false);
        ast.setType( new DoubleType(ast.getLine(), ast.getColumn()) );
        return null;
    }

    @Override
    public Type visit(StructField ast, Type param) {
        super.visit(ast, param);
        ast.setLvalue(true);
        ast.setType( ast.getExpression().getType().dot(ast.getField(), ast));
        return null;
    }

    @Override
    public Type visit(ArrayIndex ast, Type param) {
        super.visit(ast, param);
        ast.setLvalue(true);
        ast.setType( ast.getArray().getType().squareBrackets(ast.getIndex().getType(),ast));
        return null;
    }

    @Override
    public Type visit(IntLiteral ast, Type param) {
        super.visit(ast, param);
        ast.setLvalue( false );
        ast.setType( new IntType(ast.getLine(), ast.getColumn()) );
        return null;
    }

    @Override
    public Type visit(Logical ast, Type param) {
        super.visit(ast, param);
        ast.setLvalue( false );
        // Resulting logical type
        ast.setType( ast.getLeftExpression().getType().logical(ast.getRightExpression().getType(),ast));
        return null;
    }

    @Override
    public Type visit(UnaryMinus ast, Type param) {
        super.visit(ast, param);
        ast.setLvalue( false );
        ast.setType( ast.getExpression().getType().checkValidMinus(ast) );
        return null;
    }

    @Override
    public Type visit(UnaryNegative ast, Type param) {
        super.visit(ast, param);
        ast.setLvalue( false );
        ast.setType( ast.getExpression().getType().checkValidNegation(ast) );
        return null;
    }

    @Override
    public Type visit(Variable ast, Type param) {
        super.visit(ast, param);
        ast.setLvalue(true);
        if( ast.getDefinition() == null) {
            String msg = "Identifier " + ast.getName() + " is not defined";
            ast.setType(new ErrorType(ast.getLine(),ast.getColumn(),msg));
        } else {
            ast.setType( ast.getDefinition().getType() );
        }
        return null;
    }

    @Override
    public Type visit(FunctionInvocation ast, Type param) {
        super.visit(ast, param);
        ast.setLvalue(false);
        ast.setType( ast.getVariable().getType().checkValidInvoke(ast.getExpressions(),ast) );
        return null;
    }

    /* Errors Section */
    @Override
    public Type visit(Assignment ast, Type param) {
        super.visit(ast, param);
        if ( !ast.getLeft().getLvalue() )
            new ErrorType(ast.getLine(), ast.getColumn(), "Lvalue expected");
        // Type assignment checking
        ast.getLeft().getType().checkValidAssignment(ast.getRight().getType(), ast);
        return null;
    }

    @Override
    public Type visit(Read ast, Type param) {
        super.visit(ast, param);
        if ( !ast.getExpression().getLvalue() )
            new ErrorType(ast.getLine(), ast.getColumn(), "Lvalue expected");
        return null;
    }

    @Override
    public Type visit(While ast, Type param) {
        super.visit(ast, param);
        if(!ast.getExpression().getType().isBoolean(ast)){
            String msg = "Given condition '" + ast.getExpression() +"' is not boolean";
            return new ErrorType(ast.getExpression().getLine(), ast.getExpression().getColumn(), msg);
        }
        return null;
    }

    @Override
    public Type visit(If ast, Type param) {
        super.visit(ast, param);
        if(!ast.getExpression().getType().isBoolean(ast)){
            String msg = "Given condition '" + ast.getExpression() +"' is not boolean";
            return new ErrorType(ast.getExpression().getLine(), ast.getExpression().getColumn(), msg);
        }
        return null;
    }

    @Override
    public Type visit(FunctionType ast, Type param) {
        ast.getType().accept(this, param);
        for(VariableDefinition var : ast.getParameters()){
            var.accept(this, param);
        }
        return ast.getType();
    }

    @Override
    public Type visit(FunctionDefinition ast, Type param) {
        Type funcType = ast.getType().accept(this, param);
        for(Statement s : ast.getStatements()){
            s.accept(this, funcType);
        }
        return null;
    }

    @Override
    public Type visit(Return ast, Type param) {
        super.visit(ast, param);
        param.checkValidAssignment(ast.getExpression().getType(),ast);
        return null;
    }
}
