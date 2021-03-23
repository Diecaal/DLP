package ast.types;

import ast.Type;

public class DoubleType extends AbstractType {

    public DoubleType(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString(){
        return "Double";
    }
}
