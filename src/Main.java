import ast.Program;
import codeGeneration.AddressCGVisitor;
import codeGeneration.CodeGenerator;
import codeGeneration.ExecuteCGVisitor;
import codeGeneration.ValueCGVisitor;
import error.ErrorHandler;
import parser.*;

import org.antlr.v4.runtime.*;
import introspector.model.IntrospectorModel;
import introspector.view.IntrospectorTree;
import semantic.IdentificationVisitor;
import semantic.OffsetVisitor;
import semantic.TypeCheckingVisitor;

public class Main {
	
	public static void main(String... args) throws Exception {
		   if (args.length<1) {
		        System.err.println("Please, pass me the input file.");
		        return;
		    }
		   		 			
		 // create a lexer that feeds off of input CharStream
		CharStream input = CharStreams.fromFileName(args[0]);
		CmmLexer lexer = new CmmLexer(input);

		// create a parser that feeds off the tokens buffer
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		CmmParser parser = new CmmParser(tokens);

		Program ast = parser.program().ast;
		new IdentificationVisitor().visit(ast, null);
		new TypeCheckingVisitor().visit(ast, null);
		new OffsetVisitor().visit(ast, null);

		IntrospectorModel model = new IntrospectorModel("Program",ast);
		new IntrospectorTree("Introspector", model);

		if(ErrorHandler.getInstance().anyError())
			ErrorHandler.getInstance().showErrors(System.err);
		else {
			CodeGenerator cg = new CodeGenerator();
			ValueCGVisitor value = new ValueCGVisitor();
			AddressCGVisitor address = new AddressCGVisitor();
			ExecuteCGVisitor execute = new ExecuteCGVisitor();

			value.address = address;
			execute.address = address;
			address.address = address;

			value.execute = execute;
			address.execute = execute;
			execute.execute = execute;

			execute.value = value;
			address.value = value;
			value.value = value;

			execute.cg = cg;
			address.cg = cg;
			value.cg = cg;

			execute.visit(ast, null);
		}
	}
}