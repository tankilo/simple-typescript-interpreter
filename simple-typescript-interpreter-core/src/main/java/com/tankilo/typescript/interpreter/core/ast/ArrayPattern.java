package com.tankilo.typescript.interpreter.core.ast;

import java.util.List;

/**
 * @author Tankilo E-mail: tankilo@126.com
 */
public class ArrayPattern extends Node implements Pattern {

    private List<Pattern> elements;

    public List<Pattern> getElements() {
        return elements;
    }

    public void setElements(List<Pattern> elements) {
        this.elements = elements;
    }

    @Override
    public TypeAnnotationBase getTypeAnnotation() {
        return null;
    }

    @Override
    public void setTypeAnnotation(TypeAnnotationBase typeAnnotation) {

    }
}
