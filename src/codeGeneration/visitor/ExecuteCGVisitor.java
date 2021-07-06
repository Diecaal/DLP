package codeGeneration.visitor;

import ast.Definition;
import ast.Program;
import ast.Statement;
import ast.definitions.FunctionDefinition;
import ast.definitions.VariableDefinition;
import ast.statements.Assignment;
import ast.statements.FunctionInvocation;
import ast.statements.If;
import ast.statements.Read;
import ast.statements.Return;
import ast.statements.While;
import ast.statements.Write;
import ast.types.FunctionType;
import ast.types.VoidType;
import codeGeneration.utils.execute.ReturnStatementDTO;

import java.util.List;

/**
 * Handles Program, Statement [+FunctionInvocation] and Definition
 */
public class ExecuteCGVisitor extends AbstractCGVisitor<ReturnStatementDTO,Void> {

    @Override
    public Void visit(Program ast, ReturnStatementDTO param) {
        cg.writeInstruction("#source\t\"input.txt\"");
        cg.writeInstruction(" ");

        int indexLastVariableDef = 0; /* Variable definitions always placed first in programs */
        for(int i = 0 ; i < ast.getDefinitions().size() ; i++) {
            Definition definition = ast.getDefinitions().get(i);
            if(definition instanceof VariableDefinition) {
                definition.accept(execute, param);
            } else {
                indexLastVariableDef = i;
                break;
            }
        }

        cg.writeInstruction(" ");
        cg.writeComment("Invocation to main function");
        cg.writeInstruction("call main");
        cg.writeInstruction("halt");

        /* Rest of definitions (FunctionDef) after variable definitions */
        for(int i = indexLastVariableDef; i < ast.getDefinitions().size() ; i++) {
            ast.getDefinitions().get(i).accept(execute, param);
        }

        cg.showProgram();

        return null;
    }

    @Override
    public Void visit(FunctionInvocation ast, ReturnStatementDTO param) {
        cg.writeLine(ast.getLine());
        ast.getExpressions().forEach(funcParam -> funcParam.accept(value, null));
        cg.writeInstruction("call\t" + ast.getVariable().getName());

        if(!(ast.getType() instanceof VoidType)) {
            cg.writeInstruction("pop" + ast.getType().suffix());
        }

        return null;
    }

    @Override
    public Void visit(If ast, ReturnStatementDTO param) {
        super.visit(ast, null);
        cg.writeLine(ast.getLine());
        int firstLabel = cg.requestLabels(2); // 2 labels IF - ELSE
        int secondLabel = firstLabel + 1;

        cg.writeComment("* IF Statement");
        ast.getExpression().accept(value, null);
        cg.writeInstruction(String.format("jz\tlabel%d", firstLabel));

        cg.writeComment("* IF Branch Body");
        ast.getStatements_if().forEach(statement -> statement.accept(execute, param));
        cg.writeInstruction(String.format("jmp\tlabel%d", secondLabel));

        cg.writeLabel(firstLabel);

        cg.writeComment("* ELSE Branch Body");
        ast.getStatements_else().forEach(statement -> statement.accept(execute, param));

        cg.writeLabel(secondLabel);

        return null;
    }

    @Override
    public Void visit(Read ast, ReturnStatementDTO param) {
        cg.writeLine(ast.getLine());
        cg.writeComment("* Read");
        ast.getExpression().accept(address, null);
        cg.writeInstruction("in" + ast.getExpression().getType().suffix());
        cg.writeInstruction("store" + ast.getExpression().getType().suffix());

        return null;
    }

    @Override
    public Void visit(Return ast, ReturnStatementDTO param) {
        cg.writeLine(ast.getLine());
        cg.writeComment("* Return");
        ast.getExpression().accept(value, null);
        /* Return bytes -> return / local / parameters */
        cg.writeInstruction(String.format("ret\t %d, %d, %d", param.returnBytes, param.localBytes, param.parametersBytes));

        return null;
    }

    @Override
    public Void visit(While ast, ReturnStatementDTO param) {
        cg.writeLine(ast.getLine());
        int firstLabel = cg.requestLabels(2); // 2 labels WHILE

        cg.writeComment("* WHILE Statement");
        cg.writeLabel(firstLabel);

        ast.getExpression().accept(value, null);
        cg.writeInstruction("jz\tlabel" + (firstLabel + 1) );

        cg.writeComment("* WHILE Statement Body");
        ast.getStatements().forEach(statement -> statement.accept(execute, param));

        cg.writeInstruction("jmp\tlabel" + firstLabel);
        cg.writeLabel(firstLabel + 1);

        return null;
    }

    @Override
    public Void visit(Write ast, ReturnStatementDTO param) {
        cg.writeLine(ast.getLine());
        cg.writeComment("* Write");
        ast.getExpression().accept(value, null);
        cg.writeInstruction("out" + ast.getExpression().getType().suffix());

        return null;
    }

    @Override
    public Void visit(Assignment ast, ReturnStatementDTO param) {
        cg.writeLine(ast.getLine());
        cg.writeComment("* Assignment");
        ast.getLeft().accept(address, null);
        ast.getRight().accept(value, null);
        cg.writeInstruction("store" + ast.getLeft().getType().suffix());

        return null;
    }

    @Override
    public Void visit(FunctionType ast, ReturnStatementDTO param) {
        cg.writeLine(ast.getLine());
        cg.writeComment("* Parameters");
        ast.getParameters().forEach(p -> p.accept(execute, param));

        return null;
    }

    @Override
    public Void visit(FunctionDefinition ast, ReturnStatementDTO param) {
        cg.writeLine(ast.getLine());
        cg.writeInstruction(" " + ast.getName() + ":");

        ast.getType().accept(execute, param);

        cg.writeComment("* Local Variables");
        int lastVariableDef = 0;
        int localBytes = 0;
        List<Statement> statements = ast.getStatements();
        for (int i = 0 ; i < statements.size() ; i++) {
            if(statements.get(i) instanceof VariableDefinition) {
                statements.get(i).accept(execute, param);
            } else {
                lastVariableDef = i;
                if(i > 0) localBytes = - ((VariableDefinition) ast.getStatements().get(i-1)).getOffset();
                break;
            }
        }

        cg.writeInstruction("enter\t" + localBytes);

        /* Bytes to calculate { Return, Parameters, Local Bytes } */
        int returnBytes = ((FunctionType) ast.getType()).getReturnType().getNumberOfBytes();
        int parametersBytes = 0;
        for(VariableDefinition var : ((FunctionType) ast.getType()).getParameters()) {
            parametersBytes += var.getType().getNumberOfBytes();
        }

        ReturnStatementDTO dto = new ReturnStatementDTO(localBytes, parametersBytes, returnBytes);
        for(int i = lastVariableDef; i < statements.size() ; i++) {
            statements.get(i).accept(execute, dto);
        }

        if( returnBytes == 0) {
            cg.writeInstruction(String.format("ret\t %d, %d, %d", returnBytes, localBytes, parametersBytes));
        }

        return null;
    }

    @Override
    public Void visit(VariableDefinition ast, ReturnStatementDTO param) {
        //cg.writeLine(ast.getLine());
        cg.writeComment(String.format("* %s %s (offset %s)", ast.getType(), ast.getName(), ast.getOffset()));
        return null;
    }
}

/*
    execute[[Write: stm -> exp]] =
        value[[exp]]
        <out> exp.type.suffix()

    execute[[Read: stm -> exp]] =
        address[[exp]]
        <in> exp.type.suffix()
        <store> exp.type.suffix()

    execute[[Assignment: stm -> exp1 exp2]] =
        address[[exp1]]
        value[[exp2]]
        <store> exp1.type.suffix()

    execute[[Program: program -> definition*]] =
        definition*.forEach( def -> execute[[def]] )
        <call main>
        <halt>

    execute[[FunctionType: type1 -> variableDefinition* type2]] =
        variableDefinition*.forEach(p -> execute[[p]]);

    execute[[VariableDefinition: def -> type ID]] =
         <' *> type.toString() ID <offset(> def.offset <)>

    execute[[Return: statement -> exp]](int bytesLocals, int bytesParams, int bytesReturn) =
        value[[exp]]
        <ret > bytesLocals <, > bytesParams <, > bytesReturn

    execute[[If: statement1 -> exp statement2* statement3*]] =
        int labelNumber = cg.getLabels(2);
        <' * If statement>
        value[[exp]] //Condition
        <jz > labelNumber
        <' * Body IF >
        statement2*.forEach( stm -> execute[[stm]]) // If Body
        <jmp > (labelNumber+1)
        // Else label jump
        <label> labelNumber <:>
        <' * Body ELSE >
        statement3*.forEach( stm -> execute[[stm]]) // Else Body
        <label> (labelNumber+1) <:> //we need to declare jump exit label

    execute[[WhileLoop: statement1 -> expression statement2*]] =
        int labelNumber = cg.getLabel(2);
        <' * While>
        <label> labelNumber <:>
        // While condition
        value[[expression]]
        <jz label> (labelNumber+1)
        // While body - entered if labelNumber+1 did not take place
        <' * Body of the while statement>
        statement2*.forEach( stm -> execute[[stm]])
        // Jumps
        <jmp label> labelNumber
        <label> (labelNumber+1) <:> //we need to declare jump exit label
 */
