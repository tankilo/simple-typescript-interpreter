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
        @JsonSubTypes.Type(value = TSStringKeyword.class, name = "TSStringKeyword"),
        @JsonSubTypes.Type(value = TSBooleanKeyword.class, name = "TSBooleanKeyword"),
        @JsonSubTypes.Type(value = TSArrayType.class, name = "TSArrayType"),
        @JsonSubTypes.Type(value = TSAnyKeyword.class, name = "TSAnyKeyword"),
        @JsonSubTypes.Type(value = TSTypeReference.class, name = "TSTypeReference"),
        @JsonSubTypes.Type(value = TSNumberKeyword.class, name = "TSNumberKeyword")}
)
public abstract class TsType extends Node {

}
