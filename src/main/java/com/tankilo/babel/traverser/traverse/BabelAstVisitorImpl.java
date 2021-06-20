package com.tankilo.babel.traverser.traverse;

import com.tankilo.babel.traverser.ast.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
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
        } else if (statement instanceof BlockStatement) {
            visit((BlockStatement) statement, context);
        } else if (statement instanceof IfStatement) {
            visit((IfStatement) statement, context);
        }
        return null;
    }

    @Override
    public TypedValue visit(IfStatement ifStatement, ContextScope context) {
        Expression test = ifStatement.getTest();
        TypedValue testValue = visit(test, context);
        if (testValue.getType() == Boolean.class && (Boolean) testValue.getValue()) {
            visit(ifStatement.getConsequent(), context);
        } else {
            visit(ifStatement.getAlternate(), context);
        }
        return null;
    }

    @Override
    public TypedValue visit(BlockStatement blockStatement, ContextScope context) {
        ContextScope blockScope = new ContextScope(context);
        List<Statement> body = blockStatement.getBody();
        body.forEach(statement -> visit(statement, blockScope));
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
                        } else {

                        }
                    }
                } else {

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
            TypedValue initValue = visit(variableDeclarator.getInit(), context);
            context.putVariable(variableName, initValue);
        } else if (pattern instanceof ArrayPattern) {
            massAssignment((ArrayPattern) pattern, variableDeclarator.getInit(), context);
        }
        return null;
    }

    private void massAssignment(ArrayPattern pattern, Expression expression, ContextScope context) {
        ArrayPattern arrayPattern = pattern;
        List<Pattern> elements = arrayPattern.getElements();
        TypedValue initValue = visit(expression, context);
        if (initValue.getType() == List.class) {
            List<TypedValue> initList = (List<TypedValue>) initValue.getValue();
            for (int i = 0; i < elements.size(); i++) {
                Identifier identifier = (Identifier) elements.get(i);
                String variableName = identifier.getName();
                context.putVariable(variableName, initList.get(i));
            }
        }
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
        } else if (expression instanceof Identifier) {
            return visit((Identifier) expression, context);
        } else if (expression instanceof ArrayExpression) {
            return visit((ArrayExpression) expression, context);
        } else if (expression instanceof MemberExpression) {
            return visit((MemberExpression) expression, context);
        } else if (expression instanceof AssignmentExpression) {
            return visit((AssignmentExpression) expression, context);
        } else if (expression instanceof ObjectExpression) {
            return visit((ObjectExpression) expression, context);
        }
        return null;
    }

    @Override
    public TypedValue visit(AssignmentExpression expression, ContextScope context) {
        Pattern left = expression.getLeft();
        String operator = expression.getOperator();
        Expression right = expression.getRight();
        if (operator.equals("=")) {
            if (left instanceof Identifier) {
                Identifier identifier = (Identifier) left;
                TypedValue rightValue = visit(right, context);
                context.putVariable(identifier.getName(), rightValue);
            } else if (left instanceof ArrayPattern) {
                ArrayPattern arrayPattern = (ArrayPattern) left;
                massAssignment(arrayPattern, right, context);
            }
        }
        return null;
    }

    @Override
    public TypedValue visit(MemberExpression expression, ContextScope context) {
        Expression object = expression.getObject();
        Expression property = expression.getProperty();
        // A member expression. If computed is true, the node corresponds to a computed (a[b]) member expression and property is an Expression.
        // If computed is false, the node corresponds to a static (a.b) member expression and property is an Identifier or a PrivateName.
        if (expression.isComputed()) {
            if (object instanceof Identifier) {
                TypedValue typedValue = context.getVariable(((Identifier) object).getName());
                if (typedValue.getType() == List.class) {
                    List list = (List) typedValue.getValue();
                    if (property instanceof NumericLiteral) {
                        NumericLiteral numericLiteral = (NumericLiteral) property;
                        int index = Integer.parseInt(numericLiteral.getValue());
                        return (TypedValue) list.get(index);
                    }
                }
                if (typedValue.getType() == Map.class) {
                    Map map = (Map) typedValue.getValue();
                    String propertyName = "";
                    if (property instanceof StringLiteral) {
                        propertyName = ((StringLiteral) property).getValue();
                    } else if (property instanceof Identifier) {
                        propertyName = ((Identifier) property).getName();
                    }
                    Object result = map.get(propertyName);
                    if (result instanceof TypedValue) {
                        return (TypedValue) result;
                    }
                }
            }
        }
        else {
            if (object instanceof Identifier) {
                TypedValue typedValue = context.getVariable(((Identifier) object).getName());
                if (typedValue.getType() == Map.class) {
                    Map map = (Map) typedValue.getValue();
                    String propertyName = "";
                    if (property instanceof StringLiteral) {
                        propertyName = ((StringLiteral) property).getValue();
                    } else if (property instanceof Identifier) {
                        propertyName = ((Identifier) property).getName();
                    }
                    Object result = map.get(propertyName);
                    if (result instanceof TypedValue) {
                        return (TypedValue) result;
                    }
                }
            }
        }

        return null;
    }

    @Override
    public TypedValue visit(ObjectExpression expression, ContextScope context) {
        List<ObjectMemberBase> properties = expression.getProperties();
        Map<String, TypedValue> map = new HashMap<>();
        for (ObjectMemberBase property : properties) {
            if (property instanceof ObjectProperty) {
                ObjectProperty objectProperty = (ObjectProperty) property;
                if (objectProperty.getKey() instanceof Identifier) {
                    Identifier identifier = (Identifier) objectProperty.getKey();
                    TypedValue value = visit(objectProperty.getValue(), context);
                    map.put(identifier.getName(), value);
                }
            }
        }
        return new TypedValue(map, Map.class);
    }

    @Override
    public TypedValue visit(ArrayExpression expression, ContextScope context) {
        List<Expression> elements = expression.getElements();
        List<TypedValue> typedValues = elements.stream().map(s -> visit(s, context)).collect(Collectors.toList());
        return new TypedValue(typedValues, List.class);
    }

    @Override
    public TypedValue visit(StringLiteral expression, ContextScope context) {
        return new TypedValue(expression.getValue(), String.class);
    }

    @Override
    public TypedValue visit(Identifier identifier, ContextScope context) {
        return context.getVariable(identifier.getName());
    }

    @Override
    public TypedValue visit(BooleanLiteral expression, ContextScope context) {
        return new TypedValue(expression.getValue(), Boolean.class);
    }

    @Override
    public TypedValue visit(NumericLiteral expression, ContextScope context) {
        String value = expression.getValue();
        return new TypedValue(Double.valueOf(value), Double.class);
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
            case "==":
                return left.equals(right);
        }
        return null;
    }
}
