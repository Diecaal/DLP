package ast.types;

import ast.Type;
import ast.definitions.VariableDefinition;
import semantic.Visitor;

import java.util.ArrayList;
import java.util.List;

public class FunctionType extends AbstractType {
    private List<VariableDefinition> parameters;
    private Type returnType;

    public FunctionType(int line, int column, List<VariableDefinition> parameters, Type returnType) {
        super(line, column);
        this.parameters = new ArrayList<VariableDefinition>(parameters);
        this.returnType = returnType;
    }

    public Type getType(){
        return this.returnType;
    }

    public List<VariableDefinition> getParameters(){
        return this.parameters;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString(){
        return "Function Type, return:"+getType()+", parameters:"+getParameters();
    }
}
