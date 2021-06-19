package com.tankilo.babel.traverser.traverse;

import com.tankilo.babel.traverser.ast.*;

public interface BabelAstVisitor {
    TypedValue visit(Program program, ContextScope context);

    TypedValue visit(Statement statement, ContextScope context);
    TypedValue visit(VariableDeclaration variableDeclaration, ContextScope context);

    TypedValue visit(VariableDeclarator variableDeclarator, ContextScope context);

    TypedValue visit(Expression expression, ContextScope context);

    TypedValue visit(StringLiteral expression, ContextScope context);

    TypedValue visit(BooleanLiteral expression, ContextScope context);

    TypedValue visit(NumericLiteral expression, ContextScope context);

    TypedValue visit(BinaryExpression expression, ContextScope context);
}
