package com.tankilo.typescript.interpreter.core.traverse;

import com.tankilo.typescript.interpreter.core.ast.*;

/**
 * @author Tankilo E-mail: tankilo@126.com
 */
public interface BabelAstVisitor {
    TypedValue visit(Object node, ContextScope context);

    TypedValue visit(Program program, ContextScope context);

    TypedValue visit(Statement statement, ContextScope context);

    TypedValue visit(FunctionExpression expression, ContextScope context);

    TypedValue visit(NewExpression expression, ContextScope context);

    TypedValue visit(ConditionalExpression expression, ContextScope context);

    TypedValue visit(UpdateExpression expression, ContextScope context);

    TypedValue visit(LogicalExpression logicalExpression, ContextScope context);

    TypedValue visit(UnaryExpression u, ContextScope context);

    TypedValue visit(FunctionDeclaration ifStatement, ContextScope context);

    TypedValue visit(WhileStatement whileStatement, ContextScope context);

    TypedValue visit(ForOfStatement forOfStatement, ContextScope context);

    TypedValue visit(ForInStatement forInStatement, ContextScope context);

    TypedValue visit(ForStatement forStatement, ContextScope context);

    TypedValue visit(SwitchStatement switchStatement, ContextScope context);

    TypedValue visit(ReturnStatement returnStatement, ContextScope context);

    TypedValue visit(IfStatement ifStatement, ContextScope context);

    TypedValue visit(BlockStatement blockStatement, ContextScope context);

    TypedValue visit(ExpressionStatement variableDeclaration, ContextScope context);

    TypedValue visit(VariableDeclaration variableDeclaration, ContextScope context);

    TypedValue visit(CallExpression callExpression, ContextScope context);

    TypedValue visit(VariableDeclarator variableDeclarator, ContextScope context);

    TypedValue visit(Expression expression, ContextScope context);

    TypedValue visit(ArrowFunctionExpression expression, ContextScope context);

    TypedValue visit(AssignmentExpression expression, ContextScope context);

    TypedValue visit(MemberExpression expression, ContextScope context);

    TypedValue visit(ObjectExpression expression, ContextScope context);

    TypedValue visit(ArrayExpression expression, ContextScope context);

    TypedValue visit(StringLiteral expression, ContextScope context);

    TypedValue visit(Identifier identifier, ContextScope context);

    TypedValue visit(BooleanLiteral expression, ContextScope context);

    TypedValue visit(NumericLiteral expression, ContextScope context);

    TypedValue visit(BinaryExpression expression, ContextScope context);
}
