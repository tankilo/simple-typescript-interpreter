package com.tankilo.babel.traverser.ast;

public class Identifier extends Node implements Pattern {
    private String name;

    private TypeAnnotationBase typeAnnotation;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public TypeAnnotationBase getTypeAnnotation() {
        return typeAnnotation;
    }

    @Override
    public void setTypeAnnotation(TypeAnnotationBase typeAnnotation) {
        this.typeAnnotation = typeAnnotation;
    }
}
