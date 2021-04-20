package codeGeneration;

public class ExecuteCGVisitor {

}

/*
    execute[[Write: stm -> exp]] =
        value[[exp]]
        <out> exp.type.suffix()

    execute[[Read: stm -> exp]] =
        address[[exp]]
        <in> exp.type.suffix()
        <store> exp.type.suffix()

    execute[[Assignment: stm -> exp1 exp2]] =
        address[[exp1]]
        value[[exp2]]
        <store> exp1.type.suffix()

    execute[[Program: program -> definition*]] =
        definition*.forEach( def -> execute[[def]] )
        <call main>
        <halt>

    execute[[FunctionType: type1 -> variableDefinition* type2]] =
        variableDefinition*.forEach(p -> execute[[p]]);

    execute[[VariableDefinition: def -> type ID]] =
         <' *> type.toString() ID <offset(> def.offset <)>

    execute[[Return: statement -> exp]](int bytesLocals, int bytesParams, int bytesReturn) =
        value[[exp]]
        <ret > bytesLocals <, > bytesParams <, > bytesReturn

    execute[[While: statement1 -> exp statement2*]] =
        int labelNumber = cg.getLabel(2);
        <label> labelNumber <:> // : per each label
        value[[exp]]
        <jz label> (labelNumber+1)
        statement2*.forEach( stm -> execute[[stm]])
        <jmp label> labelNumber
        <label> (labelNumber+1) <:>

    execute[[If: statement1 -> exp statement2* statement3*]] =
        int labelNumber = cg.getLabels(2);
        <' * If statement>
        value[[exp]]
        <jz > labelNumber
        <' * Body IF >
        statement2*.forEach( stm -> execute[[stm]])
        <jmp > (labelNumber+1)
        // else
        <label> labelNumber <:>
        <' * Body ELSE >
        statement3*.forEach( stm -> execute[[stm]])
        <label> (labelNumber+1) <:>
 */
