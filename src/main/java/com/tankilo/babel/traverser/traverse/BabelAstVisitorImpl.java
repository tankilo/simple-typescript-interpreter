package com.tankilo.babel.traverser.traverse;

import com.tankilo.babel.traverser.ast.*;

import java.util.List;

public class BabelAstVisitorImpl implements BabelAstVisitor {
    @Override
    public TypedValue visit(Program program, ContextScope context) {
        List<Statement> statements = program.getBody();
        statements.forEach(s -> visit(s, context));
        return null;
    }

    @Override
    public TypedValue visit(Statement statement, ContextScope context) {
        if (statement instanceof VariableDeclaration) {
            visit((VariableDeclaration) statement, context);
        }
        return null;
    }

    @Override
    public TypedValue visit(VariableDeclaration variableDeclaration, ContextScope context) {
        List<VariableDeclarator> declarations = variableDeclaration.getDeclarations();
        declarations.forEach(s -> visit(s, context));
        return null;
    }


    @Override
    public TypedValue visit(VariableDeclarator variableDeclarator, ContextScope context) {
        Pattern pattern = variableDeclarator.getId();
        if (pattern instanceof Identifier) {
            Identifier identifier = (Identifier) pattern;
            String variableName = identifier.getName();
            TypeAnnotationBase typeAnnotationBase = pattern.getTypeAnnotation();
            if (typeAnnotationBase instanceof TSTypeAnnotation) {
                TSTypeAnnotation tsTypeAnnotation = (TSTypeAnnotation) pattern.getTypeAnnotation();
                Expression expression = variableDeclarator.getInit();
                TypedValue initValue = visit(expression, context);
                context.getVariables().put(variableName, initValue);
//                TsType tsType = tsTypeAnnotation.getTypeAnnotation();
//                if (tsType instanceof TSStringKeyword) {
//                    Expression expression = variableDeclarator.getInit();
//                    TypedValue initValue = visit(expression, context);
//                    context.getVariables().put(variableName, initValue);
//                } else if (tsType instanceof TSNumberKeyword) {
//                    Expression expression = variableDeclarator.getInit();
//                    TypedValue initValue = visit(expression, context);
//                    context.getVariables().put(variableName, initValue);
//                }
            }
        }
        return null;
    }

    @Override
    public TypedValue visit(Expression expression, ContextScope context) {
        if (expression instanceof StringLiteral) {
            return visit((StringLiteral) expression, context);
        } else if (expression instanceof NumericLiteral) {
            return visit((NumericLiteral) expression, context);
        } else if (expression instanceof BinaryExpression) {
            return visit((BinaryExpression) expression, context);
        }
        return null;
    }

    @Override
    public TypedValue visit(StringLiteral expression, ContextScope context) {
        return new TypedValue(expression.getValue(), String.class);
    }

    @Override
    public TypedValue visit(NumericLiteral expression, ContextScope context) {
        String value = expression.getValue();
        if (value.contains(".")) {
            return new TypedValue(Double.valueOf(value), Double.class);
        } else {
            return new TypedValue(Integer.valueOf(value), Integer.class);
        }
    }

    @Override
    public TypedValue visit(BinaryExpression expression, ContextScope context) {
        TypedValue left = visit(expression.getLeft(), context);
        TypedValue right = visit(expression.getRight(), context);
        String operator = expression.getOperator();

        switch (operator) {
            case "+":
                return left.plus(right);
            case "-":
                return left.minus(right);
            case "*":
                return left.times(right);
            case "/":
                return left.div(right);

        }

        return null;
    }
}
