package com.tankilo.babel.traverser.ast;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Identifier.class, name = "Identifier"),
        @JsonSubTypes.Type(value = ArrayPattern.class, name = "ArrayPattern")}
)
public interface Pattern {
    TypeAnnotationBase getTypeAnnotation();

    void setTypeAnnotation(TypeAnnotationBase typeAnnotation);
}
