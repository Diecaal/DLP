package semantic;

import ast.expressions.Variable;

public interface Visitor<TP,TR> {
    TR visit(Variable variable, TP parameter);
}
