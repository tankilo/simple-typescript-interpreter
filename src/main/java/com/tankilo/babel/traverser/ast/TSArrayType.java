package com.tankilo.babel.traverser.ast;

public class TSArrayType extends TsType {
    private TsType elementType;

    public TsType getElementType() {
        return elementType;
    }

    public void setElementType(TsType elementType) {
        this.elementType = elementType;
    }
}
