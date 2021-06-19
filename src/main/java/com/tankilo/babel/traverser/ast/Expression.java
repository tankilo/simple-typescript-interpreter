package com.tankilo.babel.traverser.ast;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Identifier.class, name = "Identifier"),
        @JsonSubTypes.Type(value = StringLiteral.class, name = "StringLiteral"),
        @JsonSubTypes.Type(value = NumericLiteral.class, name = "NumericLiteral"),
        @JsonSubTypes.Type(value = BooleanLiteral.class, name = "BooleanLiteral"),
        @JsonSubTypes.Type(value = BinaryExpression.class, name = "BinaryExpression")
})
public abstract class Expression extends Node {
}
