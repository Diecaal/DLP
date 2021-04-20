package codeGeneration;

public class ValueCGVisitor {

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

    value[StructField: expression1 -> expression2 . ID] =
        address[[expression1]]
        <load> expression1.type.suffix()

    value[[FunctionInvocation: expression1 -> expression2 ( params* )]] =
        params*.forEach( exp -> value[[exp]] )
        <call> expression2.name

 */
