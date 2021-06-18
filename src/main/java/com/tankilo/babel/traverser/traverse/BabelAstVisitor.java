package com.tankilo.babel.traverser.traverse;

import com.tankilo.babel.traverser.ast.VariableDeclaration;
import com.tankilo.babel.traverser.ast.VariableDeclarator;

public interface BabelAstVisitor {

    void visit(VariableDeclaration variableDeclaration, ContextScope context);

    void endVisit(VariableDeclaration variableDeclaration, ContextScope context);

    void visit(VariableDeclarator variableDeclarator, ContextScope context);

    void endVisit(VariableDeclarator variableDeclarator, ContextScope context);
}
