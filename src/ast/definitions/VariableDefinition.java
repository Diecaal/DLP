package ast.definitions;

import ast.Definition;
import ast.Statement;
import ast.Type;
import ast.definitions.AbstractDefinition;
import ast.statements.AbstractStatement;
import semantic.Visitor;

import java.util.List;

public class VariableDefinition extends AbstractStatement implements Definition {
	private int offset;
	private int scope;
	private Type type;
	private String name;

	public VariableDefinition(int line, int column, Type type, String name){
		super(line, column);
		this.name = name;
		this.type = type;
	}

	@Override
	public Type getType() {
		return this.type;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public int getScope() {
		return this.scope;
	}

	@Override
	public void setScope(int scope) {
		this.scope = scope;
	}

	@Override
	public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
		return v.visit(this, param);
	}


}
