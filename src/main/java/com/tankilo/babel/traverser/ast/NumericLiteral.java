package com.tankilo.babel.traverser.ast;

public class NumericLiteral extends Literal {
    /**
     * #TODO js里面数值类型就一个number，先保存为字符串吧，用到的时候，具体判断。
     */
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
