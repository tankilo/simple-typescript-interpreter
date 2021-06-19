package com.tankilo.babel.traverser.ast;

import java.util.List;

public class CallExpression extends Expression {
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
