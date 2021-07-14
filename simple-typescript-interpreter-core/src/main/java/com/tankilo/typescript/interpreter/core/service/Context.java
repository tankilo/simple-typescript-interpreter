package com.tankilo.typescript.interpreter.core.service;

import com.tankilo.typescript.interpreter.core.traverse.TypedValue;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Tankilo E-mail: tankilo@126.com
 */
public class Context {
    private Map<String, TypedValue> variables = new HashMap<>();

    public Map<String, TypedValue> getVariables() {
        return variables;
    }

    public void setVariables(Map<String, TypedValue> variables) {
        this.variables = variables;
    }
}
