package com.tankilo.babel.traverser.traverse;

import java.util.Objects;

public class TypedValue {

    private Class<?> type;
    private Object value;

    public TypedValue(Object value, Class<?> type) {
        this.type = type;
        this.value = value;
    }


    public TypedValue(Object value) {
        this.type = Object.class;
        this.value = value;
    }

    public void copy(TypedValue another) {
        this.type = another.getType();
        this.value = another.getValue();
    }

    public Class<?> getType() {
        return type;
    }

    public Object getValue() {
        return value;
    }

    public TypedValue plus(TypedValue other) {
        if (value instanceof String || other.getValue() instanceof String) {
            return new TypedValue(value + "" + other.getValue(), Integer.class);
        }
        return new TypedValue((Double) value + (Double) other.getValue(), Double.class);
    }

    public TypedValue minus(TypedValue other) {
        return new TypedValue((Double) value - (Double) other.getValue(), Double.class);
    }

    public TypedValue times(TypedValue other) {
        if (value instanceof Integer && other.getValue() instanceof Integer) {
            return new TypedValue((Integer) value * (Integer) other.getValue(), Integer.class);
        } else if (value instanceof Double && other.getValue() instanceof Double) {
            return new TypedValue((Double) value * (Double) other.getValue(), Double.class);
        } else if (value instanceof Integer && other.getValue() instanceof Double) {
            return new TypedValue((Integer) value * (Double) other.getValue(), Double.class);
        } else if (value instanceof Double && other.getValue() instanceof Integer) {
            return new TypedValue((Double) value * (Integer) other.getValue(), Double.class);
        }
        throw new BabelVisitException("this should never happen");
    }

    public TypedValue div(TypedValue other) {
        if (value instanceof Integer && other.getValue() instanceof Integer) {
            return new TypedValue((Integer) value * 1.0 / (Integer) other.getValue(), Double.class);
        } else if (value instanceof Double && other.getValue() instanceof Double) {
            return new TypedValue((Double) value / (Double) other.getValue(), Double.class);
        } else if (value instanceof Integer && other.getValue() instanceof Double) {
            return new TypedValue((Integer) value / (Double) other.getValue(), Double.class);
        } else if (value instanceof Double && other.getValue() instanceof Integer) {
            return new TypedValue((Double) value / (Integer) other.getValue(), Double.class);
        }
        throw new BabelVisitException("this should never happen");
    }

    public TypedValue equals(TypedValue other) {
        return new TypedValue(Objects.equals(value, other.getValue()), Boolean.class);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
