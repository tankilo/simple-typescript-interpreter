package com.tankilo.typescript.interpreter.core.ast;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * @author Tankilo E-mail: tankilo@126.com
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = ObjectProperty.class, name = "ObjectProperty"),
        @JsonSubTypes.Type(value = ObjectMethod.class, name = "ObjectMethod")}
)
public class ObjectMemberBase extends Node {
    private Expression key;
    private boolean computed;
    private boolean method;

    public Expression getKey() {
        return key;
    }

    public void setKey(Expression key) {
        this.key = key;
    }

    public boolean isComputed() {
        return computed;
    }

    public void setComputed(boolean computed) {
        this.computed = computed;
    }

    public boolean isMethod() {
        return method;
    }

    public void setMethod(boolean method) {
        this.method = method;
    }
}
