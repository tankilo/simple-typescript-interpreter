package com.tankilo.typescript.interpreter.core.ast;

import java.util.List;

/**
 * @author Tankilo E-mail: tankilo@126.com
 */
public class ObjectExpression extends Node implements Expression {
    private List<ObjectMemberBase> properties;

    public List<ObjectMemberBase> getProperties() {
        return properties;
    }

    public void setProperties(List<ObjectMemberBase> properties) {
        this.properties = properties;
    }
}
