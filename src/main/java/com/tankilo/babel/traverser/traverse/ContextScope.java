package com.tankilo.babel.traverser.traverse;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ContextScope {
    private ContextScope parent;

    public ContextScope() {
    }

    public ContextScope(ContextScope parent) {
        this.parent = parent;
    }

    private Map<String, TypedValue> variables = new HashMap<>();
    private TreeMap<String, TypedValue> functionActualParameters = new TreeMap<>();

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

    public TreeMap<String, TypedValue> getFunctionActualParameters() {
        return functionActualParameters;
    }

    public void setFunctionActualParameters(TreeMap<String, TypedValue> functionActualParameters) {
        this.functionActualParameters = functionActualParameters;
    }
}
