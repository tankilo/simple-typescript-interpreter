package com.tankilo.babel.traverser.traverse;

import java.util.HashMap;
import java.util.Map;

public class ContextScope {
    private ContextScope parent;

    public ContextScope() {
    }

    public ContextScope(ContextScope parent) {
        this.parent = parent;
    }

    private Map<String, TypedValue> variables = new HashMap<>();

    public Map<String, TypedValue> getVariables() {
        return variables;
    }

    public ContextScope getParent() {
        return parent;
    }

    public void setParent(ContextScope parent) {
        this.parent = parent;
    }
}
