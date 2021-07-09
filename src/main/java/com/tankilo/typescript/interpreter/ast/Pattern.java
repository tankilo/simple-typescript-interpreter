package com.tankilo.typescript.interpreter.ast;

public interface Pattern extends Expression {
    TypeAnnotationBase getTypeAnnotation();

    void setTypeAnnotation(TypeAnnotationBase typeAnnotation);
}
