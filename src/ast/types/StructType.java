package ast.types;

import ast.Type;

import java.util.ArrayList;
import java.util.List;

public class StructType extends AbstractType {
    private List<RecordField> recordFields;

    public StructType(int line, int column, List<RecordField> recordFields) {
        super(line, column);
        this.recordFields = new ArrayList<RecordField>(recordFields);
    }
}
