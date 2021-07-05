package ast.types;

import ast.ASTNode;
import ast.Type;
import semantic.Visitor;

import java.util.ArrayList;
import java.util.List;

public class StructType extends AbstractType {
    private List<RecordField> recordFields;

    public StructType(int line, int column, List<RecordField> recordFields) {
        super(line, column);
        this.recordFields = new ArrayList<RecordField>(recordFields);

        this.checkRepeatedFields();
        this.setNumberOfBytes(-1);
    }

    public List<RecordField> getRecordFields() {
        return recordFields;
    }

    private void checkRepeatedFields() {
        List<String> aux = new ArrayList<>();
        for(RecordField record:recordFields){
            if(!aux.contains(record.getName()))
                aux.add(record.getName());
            else
                new ErrorType(this.getLine(),this.getColumn(),"Duplicate field name '"+record.getName() + "'");
        }
    }

    public RecordField getField(String field) {
        for(RecordField record : recordFields){
            if(record.getName().equals(field))
                return record;
        }
        return null;
    }

    @Override
    public Type dot(String Id, ASTNode ast) {
        for(RecordField field : getRecordFields()){
            if(field.getName().equals(Id)){
                return field.getType();
            }
        }
        String msg = "Field " + Id + " not present in Struct";
        return new ErrorType(ast.getLine(),ast.getColumn(),msg);
    }

    @Override
    public void setNumberOfBytes(int numberOfBytes) {
        int fieldsBytes = 0;
        for(RecordField field : getRecordFields()){
            fieldsBytes += field.getType().getNumberOfBytes();
        }
        super.setNumberOfBytes(fieldsBytes);
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("struct { ");
        getRecordFields().forEach(record -> sb.append(record.toString() + ", "));
        sb.append(" }");
        return sb.toString();
    }
}
