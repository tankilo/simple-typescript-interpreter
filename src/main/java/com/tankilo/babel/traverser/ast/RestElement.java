package com.tankilo.babel.traverser.ast;

public class RestElement extends Node implements Pattern {
    private TypeAnnotationBase typeAnnotation;
    private Pattern argument;

    public Pattern getArgument() {
        return argument;
    }

    public void setArgument(Pattern argument) {
        this.argument = argument;
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
