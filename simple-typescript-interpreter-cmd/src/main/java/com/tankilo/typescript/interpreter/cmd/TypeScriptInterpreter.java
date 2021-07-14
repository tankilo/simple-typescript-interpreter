package com.tankilo.typescript.interpreter.cmd;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tankilo.typescript.interpreter.ast.generator.AstService;
import com.tankilo.typescript.interpreter.ast.generator.GraaljsAstService;
import com.tankilo.typescript.interpreter.core.BaseInterpreterException;
import com.tankilo.typescript.interpreter.core.InterpreterException;
import com.tankilo.typescript.interpreter.core.ast.File;
import com.tankilo.typescript.interpreter.core.traverse.BabelAstVisitorImpl;
import com.tankilo.typescript.interpreter.core.traverse.ContextScope;
import com.tankilo.typescript.interpreter.core.traverse.TypedValue;

/**
 * @author Tankilo E-mail: tankilo@126.com
 */
public class TypeScriptInterpreter {

    private AstService astService;
    private BabelAstVisitorImpl babelAstVisitor = new BabelAstVisitorImpl();

    public void init() throws Exception {
        astService = new GraaljsAstService();
        astService.init();
    }

    public TypedValue interprete(File file, ContextScope contextScope) {
        BabelAstVisitorImpl babelAstVisitor = new BabelAstVisitorImpl();
        babelAstVisitor.visit(file.getProgram(), contextScope);
        return null;
    }

    public TypedValue interprete(String typeScriptCode) throws BaseInterpreterException {
        String json = astService.parse(typeScriptCode);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        File file;
        try {
            file = objectMapper.readValue(json, File.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new InterpreterException("The typescript code you input is not supported yet!");
        }
        ContextScope contextScope = new ContextScope();
        interprete(file, contextScope);
        return null;
    }
}
