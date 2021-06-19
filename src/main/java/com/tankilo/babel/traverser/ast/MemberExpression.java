package com.tankilo.babel.traverser.ast;

public class MemberExpression extends Expression {
    private Expression object;
    private Expression property;

    public Expression getObject() {
        return object;
    }

    public void setObject(Expression object) {
        this.object = object;
    }

    public Expression getProperty() {
        return property;
    }

    public void setProperty(Expression property) {
        this.property = property;
    }
}
