package error;

import ast.types.ErrorType;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class ErrorHandler {

    private static ErrorHandler errorInstance;
    private List<ErrorType> errors;

    private ErrorHandler() {
        errors = new ArrayList<>();
    }

    public static ErrorHandler getInstance(){
        if(errorInstance == null){
            errorInstance = new ErrorHandler();
        }
        return errorInstance;
    }

    public void newError(ErrorType errorType) {
        if(errors != null)
            errors.add(errorType);
    }

    public boolean anyError(){
        return errors.size() != 0;
    }

    public void showErrors(PrintStream out){
        for(ErrorType e: errors)
            out.println(e.toString());
    }

}
