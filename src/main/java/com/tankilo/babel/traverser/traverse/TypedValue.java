package com.tankilo.babel.traverser.traverse;

import com.tankilo.babel.traverser.InterpreterException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
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

    @Override
    public TypedValue clone() {
        if (type == Double.class) {
            return new TypedValue(((Double) value).doubleValue(), type);
        } else if (type == Boolean.class) {
            return new TypedValue(((Boolean) value).booleanValue(), type);

        } else if (type == String.class) {
            return new TypedValue(String.valueOf(value), type);
        }
        return this;
    }

    public Class<?> getType() {
        return type;
    }

    public Object getValue() {
        return value;
    }

    public TypedValue add(TypedValue other) {
        if (value instanceof String || other.getValue() instanceof String) {
            return new TypedValue(value + "" + other.getValue(), Integer.class);
        }
        return new TypedValue((Double) value + (Double) other.getValue(), Double.class);
    }

    public TypedValue sub(TypedValue other) {
        return new TypedValue((Double) value - (Double) other.getValue(), Double.class);
    }

    public TypedValue mul(TypedValue other) {
        return new TypedValue((Double) value * (Integer) other.getValue(), Double.class);
    }

    public TypedValue div(TypedValue other) {
        return new TypedValue((Double) value / (Double) other.getValue(), Double.class);
    }

    public TypedValue mod(TypedValue other) {
        return new TypedValue((Double) value % (Double) other.getValue(), Double.class);
    }

    public TypedValue equals(TypedValue other) {
        return new TypedValue(Objects.equals(value, other.getValue()), Boolean.class);
    }

    public TypedValue notEquals(TypedValue other) {
        return new TypedValue(!Objects.equals(value, other.getValue()), Boolean.class);
    }

    public TypedValue lessThan(TypedValue other) {
        if (value instanceof Double && other.getValue() instanceof Double) {
            return new TypedValue((Double) value < (Double) other.getValue(), Boolean.class);
        } else if (value instanceof String && other.getValue() instanceof String) {
            return new TypedValue(((String) value).compareTo((String) other.getValue()) < 0, Boolean.class);
        }
        throw new BabelVisitException("Relational operators only support string or number datatype, and both operands should have the same datatype!");
    }

    public TypedValue lessThanOrEqual(TypedValue other) {
        if (value instanceof Double && other.getValue() instanceof Double) {
            return new TypedValue((Double) value <= (Double) other.getValue(), Boolean.class);
        } else if (value instanceof String && other.getValue() instanceof String) {
            return new TypedValue(((String) value).compareTo((String) other.getValue()) <= 0, Boolean.class);
        }
        throw new BabelVisitException("Relational operators only support string or number datatype, and both operands should have the same datatype!");
    }

    public TypedValue greaterThan(TypedValue other) {
        if (value instanceof Double && other.getValue() instanceof Double) {
            return new TypedValue((Double) value > (Double) other.getValue(), Boolean.class);
        } else if (value instanceof String && other.getValue() instanceof String) {
            return new TypedValue(((String) value).compareTo((String) other.getValue()) > 0, Boolean.class);
        }
        throw new BabelVisitException("Relational operators only support string or number datatype, and both operands should have the same datatype!");
    }

    public TypedValue greaterOrEqual(TypedValue other) {
        if (value instanceof Double && other.getValue() instanceof Double) {
            return new TypedValue((Double) value >= (Double) other.getValue(), Boolean.class);
        } else if (value instanceof String && other.getValue() instanceof String) {
            return new TypedValue(((String) value).compareTo((String) other.getValue()) >= 0, Boolean.class);
        }
        throw new BabelVisitException("Relational operators only support string or number datatype, and both operands should have the same datatype!");
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
