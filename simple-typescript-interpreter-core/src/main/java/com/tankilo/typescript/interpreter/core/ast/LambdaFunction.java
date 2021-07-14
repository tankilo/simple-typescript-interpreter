package com.tankilo.typescript.interpreter.core.ast;

import com.tankilo.typescript.interpreter.core.traverse.TypedValue;

import java.util.List;

/**
 * @author Tankilo E-mail: tankilo@126.com
 */
@FunctionalInterface
public interface LambdaFunction {
    TypedValue invoke(List<TypedValue> actualParams);
}
