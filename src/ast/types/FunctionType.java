package ast.types;

import ast.Type;
import ast.definitions.VariableDefinition;

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
}
