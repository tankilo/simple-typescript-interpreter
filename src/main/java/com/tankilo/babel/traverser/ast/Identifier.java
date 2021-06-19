package com.tankilo.babel.traverser.ast;

import sun.reflect.annotation.TypeAnnotation;

public class Identifier extends Expression implements Pattern {
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
