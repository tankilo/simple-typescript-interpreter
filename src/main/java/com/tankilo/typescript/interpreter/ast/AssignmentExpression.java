package com.tankilo.typescript.interpreter.ast;

public class AssignmentExpression extends Node implements Expression {
    /**
     * export type AssignmentOperator =
     * | "="
     * | "+="
     * | "-="
     * | "*="
     * | "/="
     * | "%="
     * | "<<="
     * | ">>="
     * | ">>>="
     * | "|="
     * | "^="
     * | "&=";
     */
    private String operator;
    private Expression left;
    private Expression right;

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Expression getLeft() {
        return left;
    }

    public void setLeft(Expression left) {
        this.left = left;
    }

    public Expression getRight() {
        return right;
    }

    public void setRight(Expression right) {
        this.right = right;
    }
}
