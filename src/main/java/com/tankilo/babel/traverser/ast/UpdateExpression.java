package com.tankilo.babel.traverser.ast;

public class UpdateExpression extends Node implements Expression {
    private String operator;
    private Expression argument;
    private boolean prefix;

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Expression getArgument() {
        return argument;
    }

    public void setArgument(Expression argument) {
        this.argument = argument;
    }

    public boolean isPrefix() {
        return prefix;
    }

    public void setPrefix(boolean prefix) {
        this.prefix = prefix;
    }
}
