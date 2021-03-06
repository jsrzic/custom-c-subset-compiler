package table;

import types.Type;

import java.util.HashMap;

public class VariableTable {
    public HashMap<String, Type> variables;
    public VariableTable parentTable;

    public VariableTable(VariableTable parentTable) {
        this.parentTable = parentTable;
        this.variables = new HashMap<>();
    }

    public boolean isAlreadyDeclared(String name) {
        return variables.containsKey(name);
    }

    public Type getType(String name) {
        if(variables.containsKey(name)) return variables.get(name);
        if(parentTable!=null) {
            return parentTable.getType(name);
        }
        return null;
    }

    public VariableTable getGlobalScope(){
        VariableTable table = this;
        while(table.parentTable != null){
            table = table.parentTable;
        }

        return table;
    }
}
