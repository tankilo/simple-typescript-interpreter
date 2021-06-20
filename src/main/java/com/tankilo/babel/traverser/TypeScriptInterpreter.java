package com.tankilo.babel.traverser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tankilo.babel.traverser.traverse.BabelAstVisitorImpl;
import com.tankilo.babel.traverser.traverse.ContextScope;
import com.tankilo.babel.traverser.traverse.TypedValue;

public class TypeScriptInterpreter {

    private AstService astService;
    private BabelAstVisitorImpl babelAstVisitor = new BabelAstVisitorImpl();

    public void init() throws Exception {
        astService = new GraaljsAstService();
        astService.init();
    }

    public TypedValue interprete(com.tankilo.babel.traverser.ast.File file, ContextScope contextScope) {
        BabelAstVisitorImpl babelAstVisitor = new BabelAstVisitorImpl();
        babelAstVisitor.visit(file.getProgram(), contextScope);
        return null;
    }

    public TypedValue interprete(String typeScriptCode) throws BaseInterpreterException {
        String json = astService.parse(typeScriptCode);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        com.tankilo.babel.traverser.ast.File file = null;
        try {
            file = objectMapper.readValue(json, com.tankilo.babel.traverser.ast.File.class);
        } catch (JsonProcessingException e) {
            throw new InterpreterException("The typescript code you input is not supported yet!");
        }
        ContextScope contextScope = new ContextScope();
        interprete(file, contextScope);
        return null;
    }
}
