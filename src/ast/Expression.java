package ast;

public interface Expression extends ASTNode {
    void setLvalue(boolean value);
    boolean getLvalue();

    Type getType();
    void setType(Type type);
}
