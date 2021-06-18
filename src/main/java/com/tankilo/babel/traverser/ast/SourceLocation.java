package com.tankilo.babel.traverser.ast;

public class SourceLocation {
    private Position start;
    private Position end;

    public Position getStart() {
        return start;
    }

    public void setStart(Position start) {
        this.start = start;
    }

    public Position getEnd() {
        return end;
    }

    public void setEnd(Position end) {
        this.end = end;
    }
}
