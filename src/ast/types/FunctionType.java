package ast.types;

import ast.ASTNode;
import ast.Expression;
import ast.Type;
import ast.definitions.VariableDefinition;
import ast.expressions.Variable;
import semantic.Visitor;

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

    public Type getType(){
        return this.returnType;
    }

    public List<VariableDefinition> getParameters(){
        return this.parameters;
    }

    public Type getReturnType() {
        return this.returnType;
    }

    @Override
    public Type checkValidInvoke(List<Expression> params, ASTNode ast) {
        if( params.size() == this.getParameters().size()){ //Correct params numbers incoming-expected
            for(int i=0;i<params.size();i++){
                params.get(i).getType().checkValidAssignment(this.getParameters().get(i).getType(), ast);
            }
        } else { //Correct type for each param
            String msg = "Number of parameters wrong, expected " + this.getParameters().size() + " received " + params.size();
            return new ErrorType(ast.getLine(),ast.getColumn(), msg);
        }
        return this.returnType;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString(){
        return "Function Type, return:"+getType()+", parameters:"+getParameters();
    }
}
