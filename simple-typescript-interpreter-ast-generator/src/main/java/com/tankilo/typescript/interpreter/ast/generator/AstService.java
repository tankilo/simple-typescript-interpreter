package com.tankilo.typescript.interpreter.ast.generator;

/**
 * @author Tankilo E-mail: tankilo@126.com
 */
public interface AstService {
    String parse(String typeScriptCode) throws SyntaxException;
    void init() throws Exception;
}
