package ast.definitions;

import ast.Expression;
import ast.Statement;
import ast.Type;
import ast.definitions.AbstractDefinition;
import ast.types.FunctionType;
import semantic.Visitor;

import java.util.ArrayList;
import java.util.List;

public class FunctionDefinition extends AbstractDefinition {
	private List<Statement> statements;

	public FunctionDefinition(int line, int column, String name, FunctionType functionType, List<Statement> statements) {
		super(line, column, name, functionType);
		this.statements = new ArrayList<Statement>(statements);
	}

	public List<Statement> getStatements() {
		return statements;
	}

	@Override
	public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
		return v.visit(this, param);
	}

}
