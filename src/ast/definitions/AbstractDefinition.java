package ast.definitions;

import ast.AbstractASTNode;
import ast.Definition;
import ast.Type;

public class AbstractDefinition extends AbstractASTNode implements Definition {
    private Type type;
    private String name;

    public AbstractDefinition(int line, int column,String name, Type type){
        super(line,column);
        this.name = name;
        this.type = type;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public String getName() {
        return name;
    }
}
