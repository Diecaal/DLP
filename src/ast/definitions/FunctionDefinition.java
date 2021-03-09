package ast.definitions;

import ast.Expression;
import ast.Statement;
import ast.Type;
import ast.definitions.AbstractDefinition;
import ast.types.FunctionType;

import java.util.ArrayList;
import java.util.List;

public class FunctionDefinition extends AbstractDefinition {
	private List<Statement> statements;

	public FunctionDefinition(int line, int column, String name, FunctionType functionType, List<Statement> statements) {
		super(line, column, name, functionType);
		this.statements = new ArrayList<Statement>(statements);
	}
}
