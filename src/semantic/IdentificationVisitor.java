package semantic;

import ast.Definition;
import ast.definitions.FunctionDefinition;
import ast.definitions.VariableDefinition;
import ast.expressions.*;
import ast.types.ErrorType;
import semantic.symboltable.SymbolTable;
import semantic.symboltable.SymbolTableTest;

public class IdentificationVisitor extends AbstractVisitor<Void,Void> {
    private SymbolTable symbolTable = new SymbolTable();

    @Override
    public Void visit(VariableDefinition ast, Void param){
        if (!symbolTable.insert(ast)) {
            String msg = "Identifier " + ast.getName() + " has been already defined in this scope";
            new ErrorType(ast.getLine(), ast.getColumn(), msg);
        }
        return super.visit(ast, param);
    }

    @Override
    public Void visit(FunctionDefinition ast, Void param){
        if(symbolTable.find(ast.getName())!=null)
            new ErrorType(ast.getLine(),ast.getColumn(),"Identifier " + ast.getName() + " already defined");
        else {
            symbolTable.insert(ast);
            symbolTable.set();
            super.visit(ast, param); //Traverse functionDefinition coupled
            symbolTable.reset();
        }
        return null;
    }

    @Override
    public Void visit(Variable ast, Void param) {
        Definition definition =  symbolTable.find(ast.getName());

        if( definition == null )
            new ErrorType(ast.getLine(), ast.getColumn(),"Identifier " + ast.getName() + " is not defined");
        // After retrieving definition in scope, needed to be assigned in ast (Variable)
        ast.setDefinition( definition );

        return super.visit(ast, param);
    }
}
