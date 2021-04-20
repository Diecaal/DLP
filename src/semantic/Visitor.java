package semantic;

import ast.*;
import ast.definitions.*;
import ast.expressions.*;
import ast.types.*;
import ast.statements.*;

public interface Visitor<TP,TR> {

    TR visit(Program ast, TP parameter);

    TR visit(Arithmetic ast, TP param);
    TR visit(ArrayIndex ast, TP param);
    TR visit(Cast ast, TP param);
    TR visit(CharLiteral ast, TP param);
    TR visit(IntLiteral ast, TP param);
    TR visit(Logical ast, TP param);
    TR visit(RealLiteral ast, TP param);
    TR visit(StructField ast, TP param);
    TR visit(UnaryNegative ast, TP param);
    TR visit(UnaryMinus ast, TP param);
    TR visit(Variable ast, TP param);
    TR visit(Relational ast, TP param);

    TR visit(Assignment ast, TP param);
    TR visit(FunctionInvocation ast, TP param);
    TR visit(If ast, TP param);
    TR visit(Read ast, TP param);
    TR visit(Return ast, TP param);
    TR visit(While ast, TP param);
    TR visit(Write ast, TP param);

    TR visit(ArrayType ast, TP param);
    TR visit(CharType ast, TP param);
    TR visit(DoubleType ast, TP param);
    TR visit(ErrorType ast, TP param);
    TR visit(FunctionType ast, TP param);
    TR visit(IntType ast, TP param);
    TR visit(RecordField ast, TP param);
    TR visit(StructType ast, TP param);
    TR visit(VoidType ast, TP param);

    TR visit(FunctionDefinition ast, TP param);
    TR visit(VariableDefinition ast, TP param);

}
