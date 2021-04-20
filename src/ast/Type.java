package ast;

import ast.statements.While;

import java.util.List;

public interface Type extends ASTNode {

    Type checkValidAssignment(Type type, ASTNode ast);
    Type arithmetic(Type type, ASTNode ast);
    Type comparison(Type type, ASTNode ast);
    Type logical(Type type, ASTNode ast);
    Type dot(String Id, ASTNode ast);
    Type squareBrackets(Type type, ASTNode ast);
    Type checkValidMinus(ASTNode ast);
    Type checkValidNegation(ASTNode ast);
    Type checkValidInvoke(List<Expression> params, ASTNode ast);
    boolean isBoolean(ASTNode ast);
}
