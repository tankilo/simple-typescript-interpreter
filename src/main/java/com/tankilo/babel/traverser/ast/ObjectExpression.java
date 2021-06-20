package com.tankilo.babel.traverser.ast;

import java.util.List;

public class ObjectExpression extends Node implements Expression {
    private List<ObjectMemberBase> properties;

    public List<ObjectMemberBase> getProperties() {
        return properties;
    }

    public void setProperties(List<ObjectMemberBase> properties) {
        this.properties = properties;
    }
}
