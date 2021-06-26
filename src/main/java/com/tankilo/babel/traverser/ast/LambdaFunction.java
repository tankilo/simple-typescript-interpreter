package com.tankilo.babel.traverser.ast;

import com.tankilo.babel.traverser.traverse.TypedValue;

import java.util.List;

@FunctionalInterface
public interface LambdaFunction {
    TypedValue invoke(List<TypedValue> actualParams);
}
