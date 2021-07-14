package com.tankilo.typescript.interpreter.core.ast;

import java.util.List;

/**
 * @author Tankilo E-mail: tankilo@126.com
 */
public class NewExpression extends Node implements Expression {
    private Expression callee;
    private List<Expression> arguments;

    public Expression getCallee() {
        return callee;
    }

    public void setCallee(Expression callee) {
        this.callee = callee;
    }

    public List<Expression> getArguments() {
        return arguments;
    }

    public void setArguments(List<Expression> arguments) {
        this.arguments = arguments;
    }
}
