package com.tankilo.babel.traverser.ast;

public abstract class NodeBase {
    private String type;
    private int start;
    private int end;
    private SourceLocation loc;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public SourceLocation getLoc() {
        return loc;
    }

    public void setLoc(SourceLocation loc) {
        this.loc = loc;
    }
}
