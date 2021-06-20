package com.tankilo.babel.traverser.ast;

public interface Pattern extends Expression {
    TypeAnnotationBase getTypeAnnotation();

    void setTypeAnnotation(TypeAnnotationBase typeAnnotation);
}
