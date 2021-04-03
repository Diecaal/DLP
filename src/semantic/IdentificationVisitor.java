package semantic;

import ast.definitions.FunctionDefinition;
import ast.definitions.VariableDefinition;
import ast.types.ErrorType;
import semantic.symboltable.SymbolTable;
import semantic.symboltable.SymbolTableTest;

public class IdentificationVisitor extends AbstractVisitor<Void,Void> {
    private SymbolTable symbolTable = new SymbolTable();

    @Override
    public Void visit(VariableDefinition ast, Void param){
        if(symbolTable.find(ast.getName()) == null)
            symbolTable.insert(ast);
        else
            new ErrorType(ast.getLine(),ast.getColumn(),"Variable: " + ast.getName() + " , already defined");
        return visit(ast, param);
    }

    @Override
    public Void visit(FunctionDefinition ast, Void param){
        if(symbolTable.find(ast.getName())!=null)
            new ErrorType(ast.getLine(),ast.getColumn(),"Function: " + ast.getName() + " , already defined");
        else {
            symbolTable.insert(ast);
            symbolTable.set();
            visit(ast, param);
            symbolTable.reset();
        }
        return null;
    }
}
