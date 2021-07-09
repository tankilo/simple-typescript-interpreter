package com.tankilo.typescript.interpreter.ast;

import java.util.List;

public class ArrayExpression extends Node implements Expression {
    private List<Expression> elements;

    public List<Expression> getElements() {
        return elements;
    }

    public void setElements(List<Expression> elements) {
        this.elements = elements;
    }
}
