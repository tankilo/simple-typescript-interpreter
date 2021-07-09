package com.tankilo.typescript.interpreter.traverse;

import java.util.Objects;

public class TypedValue {

    public static final TypedValue BREAK = new TypedValue(true);

    private Class<?> type;
    private Object value;

    private boolean breakFlag;

    public TypedValue(Object value, Class<?> type) {
        this.type = type;
        this.value = value;
    }

    public TypedValue(Object value) {
        this.type = Object.class;
        this.value = value;
    }

    public TypedValue(boolean breakFlag) {
        this.breakFlag = breakFlag;
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

    public void setValue(Object value) {
        this.value = value;
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

    public TypedValue negate() {
        if (value instanceof Double) {
            double d = ((Double) value).doubleValue();
            if (d == Double.MIN_VALUE) {
                throw new ArithmeticException("double overflow");
            }
            return new TypedValue(Double.valueOf(-((Double) value).doubleValue()), Double.class);
        }
        throw new BabelVisitException("The unary negation operator only support js number datatype!");
    }

    public TypedValue not() {
        if (value instanceof Boolean) {
            boolean d = ((Boolean) value).booleanValue();
            return new TypedValue(!d, Boolean.class);
        }
        throw new BabelVisitException("The logical NOT (!) operator only support js boolean datatype!");
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

    public TypedValue and(TypedValue other) {
        if (value instanceof Boolean && other.getValue() instanceof Boolean) {
            Boolean left = (Boolean) value;
            Boolean right = (Boolean) other.getValue();
            if (Boolean.FALSE.equals(value) || Boolean.FALSE.equals(other.getValue())) {
                return new TypedValue(Boolean.FALSE, Boolean.class);
            }
            if (value == null || other.getValue() == null) {
                return new TypedValue(null);
            }
            return new TypedValue(Boolean.logicalAnd(left.booleanValue(), right.booleanValue()), Boolean.class);
        }
        throw new BabelVisitException("The logical AND (&&) operator only support operands with datatype boolean!");
    }

    public TypedValue or(TypedValue other) {
        if (value instanceof Boolean && other.getValue() instanceof Boolean) {
            Boolean left = (Boolean) value;
            Boolean right = (Boolean) other.getValue();
            if (Boolean.TRUE.equals(value) || Boolean.TRUE.equals(other.getValue())) {
                return new TypedValue(Boolean.TRUE, Boolean.class);
            }
            if (value == null || other.getValue() == null) {
                return new TypedValue(null);
            }
            return new TypedValue(Boolean.logicalOr(left.booleanValue(), right.booleanValue()), Boolean.class);
        }
        throw new BabelVisitException("The logical OR (||) operator only support operands with datatype boolean!");
    }

    public boolean booleanValue() {
        if (value instanceof Boolean) {
            return ((Boolean) value).booleanValue();
        }
        throw new BabelVisitException("Expect boolean datatype!");
    }

    public double doubleValue() {
        if (value instanceof Double) {
            return ((Double) value).doubleValue();
        }
        throw new BabelVisitException("Expect nummber datatype!");
    }

    public int intValue() {
        if (value instanceof Double) {
            return (int) ((Double) value).doubleValue();
        }
        if (value instanceof Integer) {
            return ((Integer) value).intValue();
        }
        throw new BabelVisitException("Expect nummber datatype!");
    }


    public boolean isBreakFlag() {
        return breakFlag;
    }

    public void setBreakFlag(boolean breakFlag) {
        this.breakFlag = breakFlag;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
