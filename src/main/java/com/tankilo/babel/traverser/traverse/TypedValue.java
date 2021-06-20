package com.tankilo.babel.traverser.traverse;

public class TypedValue {

    private final Class<?> type;
    private final Object value;

    public TypedValue(Object value, Class<?> type) {
        this.type = type;
        this.value = value;
    }


    public TypedValue(Object value) {
        this.type = Object.class;
        this.value = value;
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
        if (value instanceof Integer && other.getValue() instanceof Integer) {
            return new TypedValue((Integer) value + (Integer) other.getValue(), Integer.class);
        } else if (value instanceof Double && other.getValue() instanceof Double) {
            return new TypedValue((Double) value + (Double) other.getValue(), Double.class);
        } else if (value instanceof Integer && other.getValue() instanceof Double) {
            return new TypedValue((Integer) value + (Double) other.getValue(), Double.class);
        } else if (value instanceof Double && other.getValue() instanceof Integer) {
            return new TypedValue((Double) value + (Integer) other.getValue(), Double.class);
        }
        throw new BabelVisitException("this should never happen");
    }

    public TypedValue minus(TypedValue other) {
        if (value instanceof Integer && other.getValue() instanceof Integer) {
            return new TypedValue((Integer) value - (Integer) other.getValue(), Integer.class);
        } else if (value instanceof Double && other.getValue() instanceof Double) {
            return new TypedValue((Double) value - (Double) other.getValue(), Double.class);
        } else if (value instanceof Integer && other.getValue() instanceof Double) {
            return new TypedValue((Integer) value - (Double) other.getValue(), Double.class);
        } else if (value instanceof Double && other.getValue() instanceof Integer) {
            return new TypedValue((Double) value - (Integer) other.getValue(), Double.class);
        }
        throw new BabelVisitException("this should never happen");
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

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
