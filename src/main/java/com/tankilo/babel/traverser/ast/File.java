package com.tankilo.babel.traverser.ast;

public class File extends Node {

    private Program program;

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }
}
