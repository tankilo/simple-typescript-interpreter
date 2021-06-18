package com.tankilo.babel.traverser.ast;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Identifier.class, name = "Identifier")}
)
public abstract class Pattern extends Node {
    private TypeAnnotationBase typeAnnotation;

    public TypeAnnotationBase getTypeAnnotation() {
        return typeAnnotation;
    }

    public void setTypeAnnotation(TypeAnnotationBase typeAnnotation) {
        this.typeAnnotation = typeAnnotation;
    }
}
