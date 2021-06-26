package com.tankilo.babel.traverser.ast;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = VariableDeclaration.class, name = "VariableDeclaration"),
        @JsonSubTypes.Type(value = ExpressionStatement.class, name = "ExpressionStatement"),
        @JsonSubTypes.Type(value = IfStatement.class, name = "IfStatement"),
        @JsonSubTypes.Type(value = BlockStatement.class, name = "BlockStatement"),
        @JsonSubTypes.Type(value = FunctionDeclaration.class, name = "FunctionDeclaration"),
        @JsonSubTypes.Type(value = ReturnStatement.class, name = "ReturnStatement")}
)
public abstract class Statement extends Node {
}
