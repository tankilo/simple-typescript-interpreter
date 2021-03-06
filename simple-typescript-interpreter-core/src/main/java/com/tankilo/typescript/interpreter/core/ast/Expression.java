package com.tankilo.typescript.interpreter.core.ast;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * @author Tankilo E-mail: tankilo@126.com
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = StringLiteral.class, name = "StringLiteral"),
        @JsonSubTypes.Type(value = CallExpression.class, name = "CallExpression"),
        @JsonSubTypes.Type(value = NumericLiteral.class, name = "NumericLiteral"),
        @JsonSubTypes.Type(value = BooleanLiteral.class, name = "BooleanLiteral"),
        @JsonSubTypes.Type(value = MemberExpression.class, name = "MemberExpression"),
        @JsonSubTypes.Type(value = ArrayExpression.class, name = "ArrayExpression"),
        @JsonSubTypes.Type(value = ObjectExpression.class, name = "ObjectExpression"),
        @JsonSubTypes.Type(value = AssignmentExpression.class, name = "AssignmentExpression"),
        @JsonSubTypes.Type(value = BinaryExpression.class, name = "BinaryExpression"),
        @JsonSubTypes.Type(value = Identifier.class, name = "Identifier"),
        @JsonSubTypes.Type(value = ArrowFunctionExpression.class, name = "ArrowFunctionExpression"),
        @JsonSubTypes.Type(value = ArrayPattern.class, name = "ArrayPattern"),
        @JsonSubTypes.Type(value = AssignmentPattern.class, name = "AssignmentPattern"),
        @JsonSubTypes.Type(value = UnaryExpression.class, name = "UnaryExpression"),
        @JsonSubTypes.Type(value = UpdateExpression.class, name = "UpdateExpression"),
        @JsonSubTypes.Type(value = FunctionExpression.class, name = "FunctionExpression"),
        @JsonSubTypes.Type(value = LogicalExpression.class, name = "LogicalExpression"),
        @JsonSubTypes.Type(value = ConditionalExpression.class, name = "ConditionalExpression"),
        @JsonSubTypes.Type(value = NewExpression.class, name = "NewExpression"),
        @JsonSubTypes.Type(value = RestElement.class, name = "RestElement")
})
public interface Expression {
}
