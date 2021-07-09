package com.tankilo.typescript.interpreter.ast;

import com.tankilo.typescript.interpreter.traverse.TypedValue;

import java.util.List;

@FunctionalInterface
public interface LambdaFunction {
    TypedValue invoke(List<TypedValue> actualParams);
}
