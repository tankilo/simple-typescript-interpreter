package com.tankilo.typescript.interpreter.core.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tankilo.typescript.interpreter.core.InterpreterException;
import com.tankilo.typescript.interpreter.core.ast.ExpressionStatement;
import com.tankilo.typescript.interpreter.core.ast.File;
import com.tankilo.typescript.interpreter.core.ast.Statement;
import com.tankilo.typescript.interpreter.core.traverse.ContextScope;
import com.tankilo.typescript.interpreter.core.traverse.TypedValue;
import com.tankilo.typescript.interpreter.core.traverse.BabelAstVisitor;
import com.tankilo.typescript.interpreter.core.traverse.BabelAstVisitorImpl;

import java.util.List;

/**
 * @author Tankilo E-mail: tankilo@126.com
 */
public class DSLService {

    private BabelAstVisitor babelAstVisitor = new BabelAstVisitorImpl();

    private File readAst(String astJson) throws InterpreterException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        File file = null;
        try {
            file = objectMapper.readValue(astJson, File.class);
        } catch (Exception e) {
            throw new InterpreterException("Failed to parse the input json", e);
        }
        return file;
    }

    public TypedValue eval(String astJson, Context context) throws InterpreterException {
        File file = readAst(astJson);
        return eval(file.getProgram(), context);
    }

    private TypedValue eval(Object node, Context context) throws InterpreterException {
        ContextScope contextScope = new ContextScope();
        context.getVariables().forEach((k, v) -> contextScope.putVariable(k, v));
        return babelAstVisitor.visit(node, contextScope);
    }

    public TypedValue evalExpression(String expression, Context context) throws InterpreterException {
        File file = readAst(expression);
        List<Statement> body = file.getProgram().getBody();
        if (!body.isEmpty()) {
            Statement statement = body.get(0);
            if (statement instanceof ExpressionStatement) {
                ExpressionStatement expressionStatement = (ExpressionStatement) statement;
                return eval(expressionStatement.getExpression(), context);
            } else {
                return eval(file.getProgram(), context);
            }
        }
        return null;
    }
}
