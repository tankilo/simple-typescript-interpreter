package com.tankilo.typescript.interpreter.core.ast;

/**
 * @author Tankilo E-mail: tankilo@126.com
 */
public interface Pattern extends Expression {
    TypeAnnotationBase getTypeAnnotation();

    void setTypeAnnotation(TypeAnnotationBase typeAnnotation);
}
