package com.tankilo.babel.traverser.ast;

public class AssignmentExpression extends Expression {
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
    private Pattern left;
    private Expression right;

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

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
}
