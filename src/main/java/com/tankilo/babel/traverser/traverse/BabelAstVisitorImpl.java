package com.tankilo.babel.traverser.traverse;

import com.tankilo.babel.traverser.ast.*;

import java.util.List;

public class BabelAstVisitorImpl implements BabelAstVisitor {
    @Override
    public void visit(VariableDeclaration variableDeclaration, ContextScope context) {
        List<VariableDeclarator> declarations = variableDeclaration.getDeclarations();
        declarations.forEach(s -> visit(s, context));
    }

    @Override
    public void endVisit(VariableDeclaration variableDeclaration, ContextScope context) {
        List<VariableDeclarator> declarations = variableDeclaration.getDeclarations();
        declarations.forEach(s -> endVisit(s, context));
    }

    @Override
    public void visit(VariableDeclarator variableDeclarator, ContextScope context) {
        Pattern pattern = variableDeclarator.getId();
        if (pattern instanceof Identifier) {
            Identifier identifier = (Identifier) pattern;
            String variableName = identifier.getName();
            TypeAnnotationBase typeAnnotationBase =  pattern.getTypeAnnotation();
            if(typeAnnotationBase instanceof TSTypeAnnotation) {
                TSTypeAnnotation tsTypeAnnotation = (TSTypeAnnotation) pattern.getTypeAnnotation();
                TsType tsType  = tsTypeAnnotation.getTypeAnnotation();
                if (tsType instanceof TSStringKeyword) {
                    Expression expression = variableDeclarator.getInit();

                }
            }
        }
    }

    @Override
    public void endVisit(VariableDeclarator variableDeclarator, ContextScope context) {

    }
}
