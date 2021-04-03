package ast.types;

import error.ErrorHandler;
import semantic.Visitor;

public class ErrorType extends AbstractType {
    private String message;

    public ErrorType(int line, int column, String message) {
        super(line, column);
        this.message = message;
        ErrorHandler.getInstance().newError(this);
    }

    public String getMessage(){
        return this.message;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString(){
        return "Error: " + getMessage();
    }
}
