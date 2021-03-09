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
}
