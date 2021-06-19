package com.tankilo.babel.traverser.traverse;

import com.tankilo.babel.traverser.ast.*;

import java.util.List;
import java.util.stream.Collectors;

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
        } else if (statement instanceof ExpressionStatement) {
            visit((ExpressionStatement) statement, context);
        }
        return null;
    }

    @Override
    public TypedValue visit(ExpressionStatement expressionStatement, ContextScope context) {
        return visit(expressionStatement.getExpression(), context);
    }

    @Override
    public TypedValue visit(VariableDeclaration variableDeclaration, ContextScope context) {
        List<VariableDeclarator> declarations = variableDeclaration.getDeclarations();
        declarations.forEach(s -> visit(s, context));
        return null;
    }

    @Override
    public TypedValue visit(CallExpression callExpression, ContextScope context) {
        Expression callee = callExpression.getCallee();
        List<Expression> arguments = callExpression.getArguments();
        List<TypedValue> valueList = arguments.stream().map(s -> visit(s, context)).collect(Collectors.toList());
        if (callee instanceof MemberExpression) {
            MemberExpression memberExpression = (MemberExpression) callee;
            Expression object = memberExpression.getObject();
            Expression property = memberExpression.getProperty();

            if (object instanceof Identifier) {
                Identifier object1 = (Identifier) object;
                if (object1.getName().equals("console")) {
                    if (property instanceof Identifier) {
                        Identifier methodName = (Identifier) property;
                        if (methodName.getName().equals("log")) {
                            valueList.forEach(s -> System.out.print(s + " "));
                            System.out.println();
                        }
                    }
                }
            }

        }

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
        } else if (expression instanceof BooleanLiteral) {
            return visit((BooleanLiteral) expression, context);
        } else if (expression instanceof CallExpression) {
            return visit((CallExpression) expression, context);
        }
        return null;
    }

    @Override
    public TypedValue visit(StringLiteral expression, ContextScope context) {
        return new TypedValue(expression.getValue(), String.class);
    }

    @Override
    public TypedValue visit(BooleanLiteral expression, ContextScope context) {
        return new TypedValue(expression.getValue(), Boolean.class);
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
