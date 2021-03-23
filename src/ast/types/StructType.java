package ast.types;

import ast.Type;

import java.util.ArrayList;
import java.util.List;

public class StructType extends AbstractType {
    private List<RecordField> recordFields;

    public StructType(int line, int column, List<RecordField> recordFields) {
        super(line, column);
        this.recordFields = new ArrayList<RecordField>(recordFields);

        this.checkRepeatedFields();
    }

    private void checkRepeatedFields() {
        List<String> aux = new ArrayList<>();
        for(RecordField record:recordFields){
            if(!aux.contains(record.getName()))
                aux.add(record.getName());
            else
                new ErrorType(this.getLine(),this.getColumn(),"Duplicate field name: "+record.getName());
        }
    }

    @Override
    public String toString(){
        return "Struct Type, fields:"+recordFields;
    }
}
