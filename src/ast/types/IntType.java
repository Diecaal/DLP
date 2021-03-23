package ast.types;

import ast.Type;

public class IntType extends AbstractType {

    public IntType(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString(){
        return  "Integer";
    }
}
