package com.tankilo.typescript.interpreter.core.ast;

/**
 * @author Tankilo E-mail: tankilo@126.com
 */
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
