package codeGeneration.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class CodeGenerator {
    private StringBuilder codeGenerated = new StringBuilder();
    private int currentLabel = 0;

    public void writeInstruction(String code) {
        codeGenerated.append("\t");
        codeGenerated.append(code + "\n");
    }

    public void outFile() {
        File file = new File("outputs/output.txt");
        BufferedWriter writer = null;
        try {
        try {
            writer = new BufferedWriter(new FileWriter(file));
            writer.write(codeGenerated.toString());
        } finally {
            if (writer != null)
                writer.close();
        } } catch (IOException e) {
            System.out.println("Error occurred with file writing");
            e.printStackTrace();
        }

    }

    public void writeInstructions(String[] lines) {
        for(int i=0 ; i<lines.length ; i++){
            this.writeInstruction( lines[i] );
        }
    }

    public void writeComment(String comment) {
        codeGenerated.append("' " + comment + "\n");
    }

    public int requestLabels(int numberOfLabels) {
        currentLabel += numberOfLabels;
        return this.currentLabel - numberOfLabels;
    }

    /* Test purpose */
    public void showProgram() {
        System.out.print(codeGenerated);
        outFile();
    }

    public void writeLabel(int labelNumber) {
        codeGenerated.append(String.format(" label%d:\n", labelNumber));
    }

    public void writeLine(int line) {
        codeGenerated.append(String.format("#Line\t%d\n", line));
    }
}
