package ast.types;

import ast.ASTNode;
import ast.Type;

public class RecordField extends AbstractType { //extends AbstractASTNode
    private Type type;
    private String name;

    public RecordField(int line, int column, Type type, String name) {
        super(line, column);
        this.type = type;
        this.name = name;
    }

    @Override
    public String toString(){
        return  "[Record Field] Type:"+getType()+", Name:"+getName();
    }

    public Type getType() {
        return this.type;
    }

    public String getName(){
        return this.name;
    }
}
