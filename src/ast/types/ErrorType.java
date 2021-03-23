package ast.types;

import error.ErrorHandler;

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
    public String toString(){
        return "Error: " + getMessage();
    }
}
