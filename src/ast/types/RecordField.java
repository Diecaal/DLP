package ast.types;

import ast.ASTNode;
import ast.Type;
import semantic.Visitor;

public class RecordField extends AbstractType { //extends AbstractASTNode
    private Type type;
    private String name;
    private int offset;

    public RecordField(int line, int column, Type type, String name) {
        super(line, column);
        this.type = type;
        this.name = name;
    }

    public Type getType() {
        return this.type;
    }

    public String getName(){
        return this.name;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString(){
        return String.format("%s %s", getType(), getName());
    }

}
