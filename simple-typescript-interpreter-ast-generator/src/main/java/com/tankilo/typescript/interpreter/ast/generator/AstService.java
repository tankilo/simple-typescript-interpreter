package com.tankilo.typescript.interpreter.ast.generator;

public interface AstService {
    String parse(String typeScriptCode) throws SyntaxException;
    void init() throws Exception;
}
