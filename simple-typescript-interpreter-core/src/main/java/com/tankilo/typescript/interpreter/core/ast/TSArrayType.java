package com.tankilo.typescript.interpreter.core.ast;

/**
 * @author Tankilo E-mail: tankilo@126.com
 */
public class TSArrayType extends TsType {
    private TsType elementType;

    public TsType getElementType() {
        return elementType;
    }

    public void setElementType(TsType elementType) {
        this.elementType = elementType;
    }
}
