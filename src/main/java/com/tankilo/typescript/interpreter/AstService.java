package com.tankilo.typescript.interpreter;

public interface AstService {
    String parse(String typeScriptCode) throws SyntaxException;
    void init() throws Exception;
}
