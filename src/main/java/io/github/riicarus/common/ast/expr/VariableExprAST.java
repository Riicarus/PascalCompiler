package io.github.riicarus.common.ast.expr;

/**
 * 变量表达式 AST
 *
 * @author Riicarus
 * @create 2023-12-7 12:15
 * @since 1.0.0
 */
public class VariableExprAST<T> extends ExprAST<T> {

    protected String name;
    protected VariableType<T> type;
    protected ValueExprAST valAST;

    public VariableExprAST(String name, VariableType<T> type, ValueExprAST valAST) {
        this.name = name;
        this.type = type;
        this.valAST = valAST;
    }

    public VariableExprAST(String name, VariableType<T> type) {
        this.name = name;
        this.type = type;
    }

    public void setValAST(ValueExprAST valAST) {
        this.valAST = valAST;
    }

    @Override
    public T compute() {
        return type.cast(valAST.value);
    }
}
