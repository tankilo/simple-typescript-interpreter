package com.tankilo.babel.traverser.ast;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

public class ForStatement extends Statement {
    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", include = JsonTypeInfo.As.PROPERTY)
    @JsonSubTypes(value = {
            @JsonSubTypes.Type(value = VariableDeclaration.class, name = "VariableDeclaration"),
            @JsonSubTypes.Type(value = Expression.class, name = "Expression")
    })
    private Node init;

    private Expression test;
    private Expression update;
    private Statement body;

    public Node getInit() {
        return init;
    }

    public void setInit(Node init) {
        this.init = init;
    }

    public Expression getTest() {
        return test;
    }

    public void setTest(Expression test) {
        this.test = test;
    }

    public Expression getUpdate() {
        return update;
    }

    public void setUpdate(Expression update) {
        this.update = update;
    }

    public Statement getBody() {
        return body;
    }

    public void setBody(Statement body) {
        this.body = body;
    }
}
