package io.github.riicarus.common.ast.expr;

import java.util.function.Function;

/**
 * 变量 AST 节点的类型
 *
 * @author Riicarus
 * @create 2023-12-6 14:53
 * @since 1.0.0
 */
public class VariableType<T> {

    public static final VariableType<Integer> INT_VARIABLE_TYPE = new VariableType<>(Integer::parseInt);
    public static final VariableType<String> STRING_VARIABLE_TYPE = new VariableType<>(val -> val);
    public static final VariableType<Double> DOUBLE_VARIABLE_TYPE = new VariableType<>(Double::parseDouble);
    public static final VariableType<Float> FLOAT_VARIABLE_TYPE = new VariableType<>(Float::parseFloat);

    private final Function<String, T> castFunc;

    public VariableType(Function<String, T> castFunc) {
        this.castFunc = castFunc;
    }

    public final T cast(String val) {
        return castFunc.apply(val);
    }

}
