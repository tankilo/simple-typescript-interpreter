package com.tankilo.typescript.interpreter.core.ast;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.List;

/**
 * @author Tankilo E-mail: tankilo@126.com
 */
public class ArrowFunctionExpression extends Node implements Expression, Function {
    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", include = JsonTypeInfo.As.PROPERTY)
    @JsonSubTypes(value = {
            @JsonSubTypes.Type(value = BlockStatement.class, name = "BlockStatement"),
            @JsonSubTypes.Type(value = Expression.class, name = "Expression")
    })
    private Node body;
    private List<Pattern> params;

    public Node getBody() {
        return body;
    }

    public void setBody(Node body) {
        this.body = body;
    }

    public List<Pattern> getParams() {
        return params;
    }

    public void setParams(List<Pattern> params) {
        this.params = params;
    }
}
