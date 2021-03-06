package com.tankilo.typescript.interpreter.core.traverse;

import com.tankilo.typescript.interpreter.core.ast.*;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Tankilo E-mail: tankilo@126.com
 */
public class BabelAstVisitorImpl implements BabelAstVisitor {
    @Override
    public TypedValue visit(Object node, ContextScope context) {
        if (node instanceof Program) {
            return visit((Program) node, context);
        }
        if (node instanceof Statement) {
            return visit((Statement) node, context);
        }
        if (node instanceof Expression) {
            return visit((Expression) node, context);
        }
        return null;
    }
    
    @Override
    public TypedValue visit(Program program, ContextScope context) {
        List<Statement> statements = program.getBody();
        statements.forEach(s -> visit(s, context));
        return null;
    }

    @Override
    public TypedValue visit(Statement statement, ContextScope context) {
        if (statement instanceof VariableDeclaration) {
            return visit((VariableDeclaration) statement, context);
        } else if (statement instanceof ExpressionStatement) {
            return visit((ExpressionStatement) statement, context);
        } else if (statement instanceof BlockStatement) {
            return visit((BlockStatement) statement, context);
        } else if (statement instanceof IfStatement) {
            return visit((IfStatement) statement, context);
        } else if (statement instanceof FunctionDeclaration) {
            visit((FunctionDeclaration) statement, context);
        } else if (statement instanceof ReturnStatement) {
            return visit((ReturnStatement) statement, context);
        } else if (statement instanceof SwitchStatement) {
            return visit((SwitchStatement) statement, context);
        } else if (statement instanceof BreakStatement) {
            return TypedValue.BREAK;
        } else if (statement instanceof ForStatement) {
            return visit((ForStatement) statement, context);
        } else if (statement instanceof ForInStatement) {
            return visit((ForInStatement) statement, context);
        } else if (statement instanceof ForOfStatement) {
            return visit((ForOfStatement) statement, context);
        } else if (statement instanceof WhileStatement) {
            return visit((WhileStatement) statement, context);
        }
        return null;
    }

    @Override
    public TypedValue visit(WhileStatement whileStatement, ContextScope context) {
        Expression test = whileStatement.getTest();
        Statement body = whileStatement.getBody();
        while (visit(test, context).booleanValue()) {
            TypedValue bodyValue = visit(body, context);
            if (bodyValue == null) {
                continue;
            }
            if (bodyValue.isBreakFlag()) {
                return null;
            }
            if (bodyValue != null) {
                return bodyValue;
            }
        }
        return null;
    }

    @Override
    public TypedValue visit(ForOfStatement forOfStatement, ContextScope context) {
        VariableDeclaration left = forOfStatement.getLeft();
        visit(left, context);
        Identifier leftId = (Identifier) left.getDeclarations().get(0).getId();
        Expression right = forOfStatement.getRight();
        TypedValue rightValue = visit(right, context);
        Statement body = forOfStatement.getBody();

        if (rightValue.getType() == List.class) {
            List list = (List) rightValue.getValue();
            for (Object o : list) {
                context.getVariable(leftId.getName()).setValue(o);
                TypedValue resultValue = visit(body, context);
                if (resultValue == null) {
                    continue;
                }
                if (resultValue.isBreakFlag()) {
                    return null;
                }
                if (resultValue != null) {
                    return resultValue;
                }
            }
        } else if (rightValue.getType() == String.class) {
            String string = (String) rightValue.getValue();
            for (int i = 0; i < string.length(); i++) {
                char c = string.charAt(i);
                context.getVariable(leftId.getName()).setValue(c);
                TypedValue resultValue = visit(body, context);
                if (resultValue == null) {
                    continue;
                }
                if (resultValue.isBreakFlag()) {
                    return null;
                }
                if (resultValue != null) {
                    return resultValue;
                }
            }
        }
        return null;
    }

    @Override
    public TypedValue visit(ForInStatement forInStatement, ContextScope context) {
        VariableDeclaration left = forInStatement.getLeft();
        visit(left, context);
        Identifier leftId = (Identifier) left.getDeclarations().get(0).getId();
        Expression right = forInStatement.getRight();
        TypedValue rightValue = visit(right, context);
        Statement body = forInStatement.getBody();

        if (rightValue.getType() == List.class) {
            List list = (List) rightValue.getValue();
            for (int i = 0; i < list.size(); i++) {
                context.getVariable(leftId.getName()).setValue(i);
                TypedValue resultValue = visit(body, context);
                if (resultValue == null) {
                    continue;
                }
                if (resultValue.isBreakFlag()) {
                    return null;
                }
                if (resultValue != null) {
                    return resultValue;
                }
            }
        } else if (rightValue.getType() == Map.class) {
            Map map = (Map) rightValue.getValue();
            Set set = map.keySet();
            for (Object o : set) {
                context.getVariable(leftId.getName()).setValue(o);
                TypedValue resultValue = visit(body, context);
                if (resultValue == null) {
                    continue;
                }
                if (resultValue.isBreakFlag()) {
                    return null;
                }
                if (resultValue != null) {
                    return resultValue;
                }
            }
        } else if (rightValue.getType() == String.class) {
            String string = (String) rightValue.getValue();
            for (int i = 0; i < string.length(); i++) {
                context.getVariable(leftId.getName()).setValue(i);
                TypedValue resultValue = visit(body, context);
                if (resultValue == null) {
                    continue;
                }
                if (resultValue.isBreakFlag()) {
                    return null;
                }
                if (resultValue != null) {
                    return resultValue;
                }
            }
        }
        return null;
    }

    @Override
    public TypedValue visit(ForStatement forStatement, ContextScope context) {
        Node init = forStatement.getInit();
        if (init instanceof VariableDeclaration) {
            visit((VariableDeclaration) init, context);
        } else {
            visit((Expression) init, context);
        }
        Expression test = forStatement.getTest();
        Expression update = forStatement.getUpdate();
        Statement body = forStatement.getBody();
        for (; test == null || visit(test, context).booleanValue(); visit(update, context)) {
            TypedValue temp = visit(body, context);
            if (null == temp) {
                continue;
            }
            if (temp.isBreakFlag()) {
                break;
            }
            return temp;
        }
        return null;
    }

    @Override
    public TypedValue visit(SwitchStatement switchStatement, ContextScope context) {
        Expression discriminant = switchStatement.getDiscriminant();
        TypedValue discriminantValue = visit(discriminant, context);
        List<SwitchCase> cases = switchStatement.getCases();
        boolean preCriterionMet = false;
        SwitchCase defaultCase = null;
        for (SwitchCase switchCase : cases) {
            Expression test = switchCase.getTest();
            if (null == test) {
                defaultCase = switchCase;
                continue;
            }
            if (preCriterionMet || discriminantValue.equals(visit(test, context)).booleanValue()) {
                preCriterionMet = true;
                List<Statement> consequent = switchCase.getConsequent();
                for (Statement statement : consequent) {
                    if (statement instanceof BreakStatement) {
                        return null;
                    }
                    if (statement instanceof ReturnStatement) {
                        return visit(statement, context);
                    }
                    TypedValue resultValue = visit(statement, context);
                    if (resultValue == null) {
                        continue;
                    }
                    if (resultValue.isBreakFlag()) {
                        return null;
                    }
                    if (resultValue != null) {
                        return resultValue;
                    }
                }
            }
        }
        List<Statement> consequent = defaultCase.getConsequent();
        for (Statement statement : consequent) {
            if (statement instanceof BreakStatement) {
                return null;
            }
            if (statement instanceof ReturnStatement) {
                return visit(statement, context);
            }
        }
        return null;
    }

    @Override
    public TypedValue visit(ReturnStatement returnStatement, ContextScope context) {
        Expression argument = returnStatement.getArgument();
        return visit(argument, context);
    }

    @Override
    public TypedValue visit(IfStatement ifStatement, ContextScope context) {
        Expression test = ifStatement.getTest();
        TypedValue testValue = visit(test, context);
        if (testValue.getType() == Boolean.class && (Boolean) testValue.getValue()) {
            return visit(ifStatement.getConsequent(), context);
        } else {
            return visit(ifStatement.getAlternate(), context);
        }
    }

    @Override
    public TypedValue visit(BlockStatement blockStatement, ContextScope context) {
        ContextScope blockScope = new ContextScope(context);
        List<Statement> body = blockStatement.getBody();
        for (int i = 0; i < body.size(); i++) {
            Statement statement = body.get(i);
            if (statement instanceof ReturnStatement) {
                return visit(statement, blockScope);
            } else {
                TypedValue value = visit(statement, blockScope);
                if (null != value && value.isBreakFlag()) {
                    return value;
                }
            }
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
                } else {
                    TypedValue method = context.getVariable(object1.getName());
                    if (method.getType() == LambdaFunction.class) {
                        LambdaFunction function = (LambdaFunction) method;
                        return function.invoke(valueList);
                    }
                }
            }
        } else if (callee instanceof Identifier) {
            TypedValue method = context.getVariable(((Identifier) callee).getName());
            if (method.getType() == LambdaFunction.class) {
                LambdaFunction function = (LambdaFunction) method.getValue();
                return function.invoke(valueList);
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
            Expression init = variableDeclarator.getInit();
            if (null != init) {
                TypedValue initValue = visit(init, context);
                context.putVariable(variableName, initValue);
            } else {
                context.putVariable(variableName, new TypedValue(null));
            }

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
        } else if (expression instanceof ArrowFunctionExpression) {
            return visit((ArrowFunctionExpression) expression, context);
        } else if (expression instanceof UnaryExpression) {
            return visit((UnaryExpression) expression, context);
        } else if (expression instanceof LogicalExpression) {
            return visit((LogicalExpression) expression, context);
        } else if (expression instanceof UpdateExpression) {
            return visit((UpdateExpression) expression, context);
        } else if (expression instanceof FunctionExpression) {
            return visit((FunctionExpression) expression, context);
        } else if (expression instanceof ConditionalExpression) {
            return visit((ConditionalExpression) expression, context);
        } else if (expression instanceof NewExpression) {
            return visit((NewExpression) expression, context);
        }
        return null;
    }

    @Override
    public TypedValue visit(NewExpression expression, ContextScope context) {
        return null;
    }

    @Override
    public TypedValue visit(ConditionalExpression expression, ContextScope context) {
        Expression test = expression.getTest();
        Expression alternate = expression.getAlternate();
        Expression consequent = expression.getConsequent();
        return visit(test, context).booleanValue() ? visit(consequent, context) : visit(alternate, context);
    }

    @Override
    public TypedValue visit(UpdateExpression expression, ContextScope context) {
        Expression argument = expression.getArgument();
        TypedValue argumentValue = visit(argument, context);
        String operator = expression.getOperator();
        double oldValue = argumentValue.doubleValue();
        double newValue;
        boolean prefix = expression.isPrefix();
        switch (operator) {
            case "++":
                newValue = argumentValue.doubleValue() + 1;
                argumentValue.copy(new TypedValue(newValue, Double.class));
                return new TypedValue(prefix ? newValue : oldValue, Double.class);
            case "--":
                newValue = argumentValue.doubleValue() - 1;
                argumentValue.copy(new TypedValue(newValue, Double.class));
                return new TypedValue(prefix ? newValue : oldValue, Double.class);
        }
        return null;
    }

    @Override
    public TypedValue visit(LogicalExpression expression, ContextScope context) {
        Expression left = expression.getLeft();
        Expression right = expression.getRight();
        String operator = expression.getOperator();
        boolean leftValue;
        boolean rightValue;
        switch (operator) {
            case "&&":
                leftValue = visit(left, context).booleanValue();
                if (!leftValue) {
                    return new TypedValue(Boolean.FALSE, Boolean.class);
                }
                rightValue = visit(right, context).booleanValue();
                return new TypedValue(rightValue, Boolean.class);
            case "||":
                leftValue = visit(left, context).booleanValue();
                if (leftValue) {
                    return new TypedValue(Boolean.TRUE, Boolean.class);
                }
                rightValue = visit(right, context).booleanValue();
                return new TypedValue(rightValue, Boolean.class);
        }
        return null;
    }

    @Override
    public TypedValue visit(UnaryExpression unaryExpression, ContextScope context) {
        Expression argument = unaryExpression.getArgument();
        TypedValue argumentValue = visit(argument, context);
        String operator = unaryExpression.getOperator();
        switch (operator) {
            case "-":
                return argumentValue.negate();
            case "!":
                return argumentValue.not();
        }
        return null;
    }


    @Override
    public TypedValue visit(FunctionExpression expression, ContextScope context) {
        return visit((FunctionBase) expression, context);
    }

    public TypedValue visit(FunctionBase expression, ContextScope context) {
        BlockStatement body = expression.getBody();
        List<Pattern> params = expression.getParams();
        Map<String, TypedValue> formalParameters = new LinkedHashMap<>();
        boolean hasRestParamter = false;
        for (int i = 0; i < params.size(); i++) {
            Pattern formalParameter = params.get(i);
            if (formalParameter instanceof Identifier) {
                formalParameters.put(((Identifier) formalParameter).getName(), new TypedValue(null));
            } else if (formalParameter instanceof RestElement) {
                RestElement restElement = (RestElement) formalParameter;
                Pattern argument = restElement.getArgument();
                formalParameters.put(((Identifier) argument).getName(), new TypedValue(null));
                assert i == params.size() - 1;
                hasRestParamter = true;
            } else if (formalParameter instanceof AssignmentPattern) {
                AssignmentPattern assignmentPattern = (AssignmentPattern) formalParameter;
                Identifier left = (Identifier) assignmentPattern.getLeft();
                TypedValue defaultValue = visit(assignmentPattern.getRight(), context);
                formalParameters.put(left.getName(), defaultValue);
            }
        }
        boolean finalHasRestParamter = hasRestParamter;
        return new TypedValue(new LambdaFunction() {
            @Override
            public TypedValue invoke(List<TypedValue> actualParams) {
                Map<String, TypedValue> functionActualParameters = context.getFunctionActualParameters();
                String[] keySet = formalParameters.keySet().toArray(new String[0]);
                for (int i = 0; i < keySet.length; i++) {
                    if (i == keySet.length - 1 && finalHasRestParamter) {
                        functionActualParameters.put(keySet[i], new TypedValue(actualParams.subList(i, actualParams.size()), List.class));
                        break;
                    }
                    if (i < actualParams.size()) {
                        TypedValue actualParam = actualParams.get(i);
                        if (actualParam.getValue() == null) {
                            TypedValue formalParamValue = formalParameters.get(keySet[i]);
                            if (formalParamValue.getValue() != null) {
                                functionActualParameters.put(keySet[i], formalParamValue.clone());
                            }
                        } else {
                            functionActualParameters.put(keySet[i], actualParam);
                        }
                    } else {
                        TypedValue formalParamValue = formalParameters.get(keySet[i]);
                        if (formalParamValue.getValue() != null) {
                            functionActualParameters.put(keySet[i], formalParamValue.clone());
                        }
                    }
                }
                TypedValue result = visit(body, context);
                context.getFunctionActualParameters().clear();
                return result;
            }
        }, LambdaFunction.class);
    }

    @Override
    public TypedValue visit(FunctionDeclaration functionDeclaration, ContextScope context) {
        Identifier functionIdentifier = functionDeclaration.getId();
        context.putVariable(functionIdentifier.getName(), visit((FunctionBase) functionDeclaration, context));
        return null;
    }


    @Override
    public TypedValue visit(ArrowFunctionExpression expression, ContextScope context) {
        Map<String, TypedValue> formalParameters = new HashMap<>();
        boolean hasRestParamter = false;
        for (int i = 0; i < expression.getParams().size(); i++) {
            Pattern formalParameter = expression.getParams().get(i);
            if (formalParameter instanceof Identifier) {
                formalParameters.put(((Identifier) formalParameter).getName(), new TypedValue(null));
            } else if (formalParameter instanceof RestElement) {
                assert i == expression.getParams().size() - 1;
                hasRestParamter = true;
            }
        }
        Node body = expression.getBody();
        boolean finalHasRestParamter = hasRestParamter;
        return new TypedValue(new LambdaFunction() {
            @Override
            public TypedValue invoke(List<TypedValue> actualParams) {
                Map<String, TypedValue> functionActualParameters = context.getFunctionActualParameters();
                String[] keySet = formalParameters.keySet().toArray(new String[0]);
                for (int i = 0; i < keySet.length; i++) {
                    if (i == keySet.length - 1 && finalHasRestParamter) {
                        functionActualParameters.put(keySet[i], new TypedValue(actualParams.subList(i, actualParams.size()), List.class));
                    }
                    TypedValue actualParam = actualParams.get(i);
                    functionActualParameters.put(keySet[i], actualParam);
                }
                TypedValue result;
                if (body instanceof BlockStatement) {
                    result = visit((BlockStatement) body, context);
                } else {
                    result = visit((Expression) body, context);
                }
                context.getFunctionActualParameters().clear();
                return result;
            }
        }, LambdaFunction.class);
    }

    @Override
    public TypedValue visit(AssignmentExpression expression, ContextScope context) {
        Expression left = expression.getLeft();
        String operator = expression.getOperator();
        Expression right = expression.getRight();
        if (operator.equals("=")) {
            if (left instanceof Identifier) {
                Identifier identifier = (Identifier) left;
                TypedValue rightValue = visit(right, context);
                TypedValue typedValue = context.getVariable(identifier.getName());
                typedValue.copy(rightValue);
            } else if (left instanceof ArrayPattern) {
                ArrayPattern arrayPattern = (ArrayPattern) left;
                massAssignment(arrayPattern, right, context);
            } else if (left instanceof MemberExpression) {
                MemberExpression memberExpression = (MemberExpression) left;
                TypedValue typedValue = visit(memberExpression, context);
                TypedValue rightValue = visit(right, context);
                typedValue.copy(rightValue);
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
                    } else if (property instanceof Identifier) {
                        int index = context.getVariable(((Identifier) property).getName()).intValue();
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
                if (typedValue.getType() == String.class) {
                    String string = (String) typedValue.getValue();
                    if (property instanceof NumericLiteral) {
                        NumericLiteral numericLiteral = (NumericLiteral) property;
                        int index = Integer.parseInt(numericLiteral.getValue());
                        return new TypedValue(string.charAt(index));
                    } else if (property instanceof Identifier) {
                        int index = context.getVariable(((Identifier) property).getName()).intValue();
                        return new TypedValue(string.charAt(index));
                    }
                }
            }
        } else {
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
                    if (null == result) {
                        TypedValue tv = new TypedValue(null);
                        map.put(propertyName, tv);
                        return tv;
                    }
                    if (result instanceof TypedValue) {
                        return (TypedValue) result;
                    }
                }
            } else if (object instanceof MemberExpression) {
                TypedValue left = visit((MemberExpression) object, context);
                if (left.getType() == Map.class) {
                    Map leftMap = (Map) left.getValue();
                    if (property instanceof Identifier) {
                        String propertyName = ((Identifier) property).getName();
                        return (TypedValue) leftMap.get(propertyName);
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
                    if (value == null) {
                        value = new TypedValue(null);
                    }
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
        if (identifier.getName().equals("undefined")) {
            return new TypedValue(null);
        }
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
                return left.add(right);
            case "-":
                return left.sub(right);
            case "*":
                return left.mul(right);
            case "/":
                return left.div(right);
            case "%":
                return left.mod(right);
            case "==":
            case "===":
                return left.equals(right);
            case "!=":
            case "!==":
                return left.notEquals(right);
            case "<":
                return left.lessThan(right);
            case "<=":
                return left.lessThanOrEqual(right);
            case ">":
                return left.greaterThan(right);
            case ">=":
                return left.greaterOrEqual(right);
        }
        return null;
    }
}
