package com.tankilo.babel.traverser.traverse;

import com.tankilo.babel.traverser.ast.*;

public interface BabelAstVisitor {
    TypedValue visit(Program program, ContextScope context);

    TypedValue visit(Statement statement, ContextScope context);

    TypedValue visit(IfStatement ifStatement, ContextScope context);

    TypedValue visit(BlockStatement blockStatement, ContextScope context);

    TypedValue visit(ExpressionStatement variableDeclaration, ContextScope context);

    TypedValue visit(VariableDeclaration variableDeclaration, ContextScope context);

    TypedValue visit(CallExpression callExpression, ContextScope context);

    TypedValue visit(VariableDeclarator variableDeclarator, ContextScope context);

    TypedValue visit(Expression expression, ContextScope context);

    TypedValue visit(AssignmentExpression expression, ContextScope context);

    TypedValue visit(MemberExpression expression, ContextScope context);

    TypedValue visit(ArrayExpression expression, ContextScope context);

    TypedValue visit(StringLiteral expression, ContextScope context);

    TypedValue visit(Identifier identifier, ContextScope context);

    TypedValue visit(BooleanLiteral expression, ContextScope context);

    TypedValue visit(NumericLiteral expression, ContextScope context);

    TypedValue visit(BinaryExpression expression, ContextScope context);
}
