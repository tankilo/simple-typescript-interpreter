package com.tankilo.babel.traverser.ast;

public class BinaryExpression extends Expression {

    /**
     * export type BinaryOperator =
     *   | "=="
     *   | "!="
     *   | "==="
     *   | "!=="
     *   | "<"
     *   | "<="
     *   | ">"
     *   | ">="
     *   | "<<"
     *   | ">>"
     *   | ">>>"
     *   | "+"
     *   | "-"
     *   | "*"
     *   | "/"
     *   | "%"
     *   | "|"
     *   | "^"
     *   | "&"
     *   | "in"
     *   | "instanceof";
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
