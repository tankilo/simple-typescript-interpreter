package com.tankilo.babel.traverser.traverse;

import java.util.HashMap;
import java.util.Map;

public class ContextScope {
    private ContextScope parent;

    private Map<String, Object> variables = new HashMap<>();

    public Map<String, Object> getVariables() {
        return variables;
    }

    public ContextScope getParent() {
        return parent;
    }

    public void setParent(ContextScope parent) {
        this.parent = parent;
    }
}
