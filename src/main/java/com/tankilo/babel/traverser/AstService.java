package com.tankilo.babel.traverser;

public interface AstService {
    String parse(String typeScriptCode) throws SyntaxException;
    void init() throws Exception;
}
