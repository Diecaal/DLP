package semantic;

import ast.expressions.Variable;


public class TypeCheckingVisitor extends AbstractVisitor<Void,Void> {
    @Override
    public Void visit(Variable variable, Void param){
        super.visit(variable,param);
        variable.setLvalue(false);
        return null;
    }
}
