package codeGeneration.visitor;

import ast.Expression;
import ast.expressions.Arithmetic;
import ast.expressions.ArrayIndex;
import ast.expressions.Cast;
import ast.expressions.CharLiteral;
import ast.expressions.IntLiteral;
import ast.expressions.Logical;
import ast.expressions.RealLiteral;
import ast.expressions.Relational;
import ast.expressions.StructField;
import ast.expressions.UnaryMinus;
import ast.expressions.UnaryNegative;
import ast.expressions.Variable;
import ast.statements.FunctionInvocation;
import codeGeneration.visitor.AbstractCGVisitor;

public class ValueCGVisitor extends AbstractCGVisitor<Void,Void> {

    @Override
    public Void visit(Arithmetic ast, Void param) { // Remember we're converting into resulting (exp1) type
        ast.getLeftExpression().accept(this, param);
        /* exp2.type.convertTo(exp1.type) */
        String[] castLeft = ast.getLeftExpression().getType().convertTo(ast.getType());
        cg.writeInstructions( castLeft );
        ast.getRightExpression().accept(this, param);
        /* exp3.type.convertTo(exp1.type) */
        String[] castRight = ast.getRightExpression().getType().convertTo(ast.getType());
        cg.writeInstructions( castRight );

        switch (ast.getOperator()){
            case "+":
                cg.writeInstruction("add" + ast.getType().suffix());
                break;
            case "-":
                cg.writeInstruction("sub" + ast.getType().suffix());
                break;
            case "*":
                cg.writeInstruction("mul" + ast.getType().suffix());
                break;
            case "/":
                cg.writeInstruction("div" + ast.getType().suffix());
                break;
            case "%":
                cg.writeInstruction("mod" + ast.getType().suffix());
                break;
            default:
                break;
        }

        return null;
    }

    @Override
    public Void visit(Relational ast, Void param) {
        ast.getLeftExpression().accept(this, param);
        ast.getRightExpression().accept(this, param);
        switch (ast.getOperator()) {
            case ">":
                cg.writeInstruction("gt" + ast.getType().suffix());
                break;
            case ">=":
                cg.writeInstruction("ge" + ast.getType().suffix());
                break;
            case "<":
                cg.writeInstruction("lt" + ast.getType().suffix());
                break;
            case "<=":
                cg.writeInstruction("le" + ast.getType().suffix());
                break;
            case "!=":
                cg.writeInstruction("ne" + ast.getType().suffix());
                break;
            case "==":
                cg.writeInstruction("eq" + ast.getType().suffix());
                break;
            default:
                break;
        }

        return null;
    }

    @Override
    public Void visit(ArrayIndex ast, Void param) {
        ast.accept(address, param);
        cg.writeInstruction("load" + ast.getType().suffix());

        return null;
    }

    @Override
    public Void visit(Cast ast, Void param) {
        ast.getExpression().accept(this, param);
        String[] castLines = ast.getExpression().getType().convertTo(ast.getTypeCast());
        cg.writeInstructions( castLines );

        return null;
    }

    @Override
    public Void visit(CharLiteral ast, Void param) {
        cg.writeInstruction("pushb\t" + ast.getASCII());

        return null;
    }

    @Override
    public Void visit(IntLiteral ast, Void param) {
        cg.writeInstruction("pushi\t" + ast.getValue());

        return null;
    }

    @Override
    public Void visit(RealLiteral ast, Void param) {
        cg.writeInstruction("pushf\t" + ast.getValue());

        return null;
    }

    @Override
    public Void visit(Logical ast, Void param) {
        ast.getLeftExpression().accept(this, param);
        ast.getRightExpression().accept(this, param);

        if(ast.getOperator().equals("&&"))
            cg.writeInstruction("and\t");
        else if(ast.getOperator().equals("||"))
            cg.writeInstruction("or\t");

        return null;
    }

    @Override
    public Void visit(StructField ast, Void param) {
        ast.accept(address, param);
        cg.writeInstruction("load" + ast.getType().suffix());

        return null;
    }

    @Override
    public Void visit(UnaryNegative ast, Void param) {
        ast.getExpression().accept(this, param);
        cg.writeInstruction("not");

        return null;
    }

    @Override
    public Void visit(UnaryMinus ast, Void param) {
        ast.getExpression().accept(this, param);
        cg.writeInstruction("-");

        return null;
    }

    @Override
    public Void visit(Variable ast, Void param) {
        ast.accept(address, param);
        cg.writeInstruction("load" + ast.getType().suffix());

        return null;
    }


    @Override
    public Void visit(FunctionInvocation ast, Void param) {
        for(Expression funcParam : ast.getExpressions())
            funcParam.accept(value, param);
        cg.writeInstruction("call " + ast.getVariable().getName());

        return null;
    }
}

/*
    value[[Arithmetic: exp1 -> exp2 (+|-|*|/) exp3]] =
        value[[exp2]]
        exp2.type.convertTo(exp1.type);
        value[[exp3]]
        exp3.type.convertTo(exp1.type);
        switch(exp1.operator) {
            case "+" : <add> exp1.type.suffix(); break;
            case "-" : <sub> exp1.type.suffix(); break;
            case "*" : <mul> exp1.type.suffix(); break;
            case "/" : <div> exp1.type.suffix(); break;
        }

    value[[Relational: exp1 -> exp2 (>|>=|<|<=|!=|==) exp3]] =
        value[[exp2]]
        value[[exp3]]
        switch (exp1.operator) {
         case ">": <gt> exp1.type.suffix() break;
         case ">=": <ge> exp1.type.suffix() break;
         case "<": <lt> exp1.type.suffix() break;
         case "<=": <le> exp1.type.suffix() break;
         case "!=": <ne> exp1.type.suffix() break;
         case "==": <eq> exp1.type.suffix() break;
    }

    value[[Logical: exp1 -> exp2 (&& | ||) exp3]] =
     value[[exp2]]
     value[[exp3]]
     switch (exp1.operator) {
         case "&&": <and> break;
         case "||": <or> break;
    }

    value[[UnaryNegative: exp1 -> ! exp2]] =
        value[[exp2]]
        <not>

    value[[RealLiteral: exp -> REAL_CONSTANT]] =
        <pushf> exp.value

    value[[IntLiteral: exp -> INT_CONSTANT]] =
        <pushi> exp.value

    value[[CharLiteral: exp -> CHAR_CONSTANT]] =
        <pushb> exp.value

    value[[Cast: exp1 -> type exp2]] =
        value[[exp2]]
        exp2.type.convertTo(type)

    value[[Variable: exp -> ID]] =
        address[[exp]]
        <load> exp.type.suffix()

    value[[ArrayIndex: expression1 -> expression2 [ expression3 ] ]] =
        address[[expression1]]
        <load> expression2.type.arrayType.suffix()

    value[[FunctionInvocation: expression1 -> expression2 ( params* )]] =
        params*.forEach( exp -> value[[exp]] )
        <call> expression2.name

    value[StructField: expression1 -> expression2 . ID] =
        address[[expression1]]
        <load> expression1.type.suffix()

 */
