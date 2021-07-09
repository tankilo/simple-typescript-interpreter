package com.tankilo.typescript.interpreter.traverse;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ContextScope {
    private ContextScope parent;

    public ContextScope() {
    }

    public ContextScope(ContextScope parent) {
        this.parent = parent;
    }

    private Map<String, TypedValue> variables = new HashMap<>();
    private Map<String, TypedValue> functionActualParameters = new LinkedHashMap<>();

    public TypedValue getVariable(String name) {
        if (functionActualParameters.containsKey(name)) {
            return functionActualParameters.get(name);
        }
        if (variables.containsKey(name)) {
            return variables.get(name);
        }
        if (parent != null) {
            return parent.getVariable(name);
        } else {
            return new TypedValue(null);
        }
    }

    public void putVariable(String name, TypedValue value) {
        variables.put(name, value);
    }

    public ContextScope getParent() {
        return parent;
    }

    public void setParent(ContextScope parent) {
        this.parent = parent;
    }

    public Map<String, TypedValue> getFunctionActualParameters() {
        return functionActualParameters;
    }
}
