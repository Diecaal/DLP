package codeGeneration.utils.execute;

public class ReturnStatementDTO {

    public int localBytes, parametersBytes, returnBytes;

    public ReturnStatementDTO(int localBytes, int parametersBytes, int returnBytes){
        this.localBytes = localBytes;
        this.parametersBytes = parametersBytes;
        this.returnBytes = returnBytes;
    }
}