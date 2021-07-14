package com.tankilo.typescript.interpreter.core.ast;

/**
 * @author Tankilo E-mail: tankilo@126.com
 */
public class TSTypeAnnotation extends TypeAnnotationBase {
    private TsType typeAnnotation;

    public TsType getTypeAnnotation() {
        return typeAnnotation;
    }

    public void setTypeAnnotation(TsType typeAnnotation) {
        this.typeAnnotation = typeAnnotation;
    }
}
