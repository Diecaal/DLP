package semantic;

import ast.expressions.Variable;

public class AbstractVisitor<TP,TR> implements Visitor<TP,TR> {
    @Override
    public TR visit(Variable variable, TP parameter) {
        return null;
    }
}
