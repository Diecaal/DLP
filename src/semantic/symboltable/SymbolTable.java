package semantic.symboltable;

import java.util.*;
import ast.Definition;

public class SymbolTable {
	
	private int scope=0;
	private List<Map<String,Definition>> table;

	public SymbolTable()  {
		table = new ArrayList<>();
		table.add( new HashMap<>() );
	}

	public void set() {
		table.add( new HashMap<>() );
		this.scope++;
	}
	
	public void reset() {
		table.remove(this.scope);
		this.scope--;
	}
	
	public boolean insert(Definition definition) {
		Map<String, Definition> scope = table.get( this.scope );
		if(scope.get(definition.getName())!=null) //Defined in scope before
			return false;
		scope.put( definition.getName(), definition );
		definition.setScope( this.scope );
		return true;
	}
	
	public Definition find(String id) {
		int initialScope = this.scope;
		Definition definition = null;
		while( this.scope >= 0 && definition == null ){
				definition = findInCurrentScope(id);
				this.scope--;
		}
		this.scope = initialScope;
		return definition;
	}

	public Definition findInCurrentScope(String id) {
		Map<String, Definition> scope = table.get( this.scope );
		return scope.get( id );
	}
}
