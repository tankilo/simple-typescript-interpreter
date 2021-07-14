package com.tankilo.typescript.interpreter.core.ast;

import java.util.List;

/**
 * @author Tankilo E-mail: tankilo@126.com
 */
public class ArrayExpression extends Node implements Expression {
    private List<Expression> elements;

    public List<Expression> getElements() {
        return elements;
    }

    public void setElements(List<Expression> elements) {
        this.elements = elements;
    }
}
