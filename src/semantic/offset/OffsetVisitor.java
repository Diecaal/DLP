package semantic.offset;

import ast.Statement;
import ast.definitions.*;
import ast.types.*;
import semantic.AbstractVisitor;

import java.util.List;

public class OffsetVisitor extends AbstractVisitor<Integer,Void> {

    private int globalVariablesBytes = 0;

    @Override
    public Void visit(FunctionDefinition ast, Integer param) {
        ast.getType().accept( this, param );

        int localSize = 0;
        /* Normal order in local variables definitions */
        for (Statement statement: ast.getStatements()) {
            if (statement instanceof VariableDefinition)
                localSize += ((VariableDefinition) statement).getType().getNumberOfBytes();
            statement.accept(this, -localSize); //Remember '-' sign for this
        }

        return null;
    }

    @Override
    public Void visit(FunctionType ast, Integer param) {
        ast.getType().accept(this, param);

        int parametersBytes = 0;
        /* Reverse order applied in parameters */
        List<VariableDefinition> params = ast.getParameters();
        for(int i=params.size()-1 ; i >= 0 ; i--) {
            VariableDefinition var = params.get(i);
            var.accept(this, parametersBytes + 4);
            parametersBytes += var.getType().getNumberOfBytes();
        }
        return null;
    }

    @Override
    public Void visit(VariableDefinition ast, Integer param) {
        super.visit(ast, param);

        if(ast.getScope() == 0){
            ast.setOffset( this.globalVariablesBytes ); // Global
            this.globalVariablesBytes += ast.getType().getNumberOfBytes();
        } else {
            ast.setOffset( param ); // Local - parameter
        }
        return null;
    }

    @Override
    public Void visit(StructType ast, Integer param) {
        int fieldsBytes = 0;
        for(RecordField record : ast.getRecordFields()) {
            record.accept(this, fieldsBytes);
            fieldsBytes += record.getType().getNumberOfBytes();
        }
        return null;
    }

    @Override
    public Void visit(RecordField ast, Integer param) {
        super.visit(ast, param);
        ast.setOffset( param );
        return null;
    }
}
