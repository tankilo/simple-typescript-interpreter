package com.tankilo.babel.traverser.ast;

public class AssignmentPattern implements Pattern {

    private TypeAnnotationBase typeAnnotation;

    private Pattern left;
    private Expression right;

    public Pattern getLeft() {
        return left;
    }

    public void setLeft(Pattern left) {
        this.left = left;
    }

    public Expression getRight() {
        return right;
    }

    public void setRight(Expression right) {
        this.right = right;
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
