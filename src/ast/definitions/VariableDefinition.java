package ast.definitions;

import ast.Definition;
import ast.Statement;
import ast.Type;
import ast.definitions.AbstractDefinition;
import ast.statements.AbstractStatement;

public class VariableDefinition extends AbstractStatement implements Definition {
	private int offset;
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

}
