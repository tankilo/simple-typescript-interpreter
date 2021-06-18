package com.tankilo.babel.traverser.ast;

public class TSTypeAnnotation extends TypeAnnotationBase {
    private TsType typeAnnotation;

    public TsType getTypeAnnotation() {
        return typeAnnotation;
    }

    public void setTypeAnnotation(TsType typeAnnotation) {
        this.typeAnnotation = typeAnnotation;
    }
}
