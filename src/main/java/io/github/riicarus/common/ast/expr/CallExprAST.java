package io.github.riicarus.common.ast.expr;

import java.util.List;

/**
 * 函数调用表达式 AST
 *
 * @author Riicarus
 * @create 2023-12-7 12:26
 * @since 1.0.0
 */
public class CallExprAST<T> extends ExprAST<T> {

    protected String callFuncName;
    protected List<ExprAST<?>> args;

    @Override
    public T compute() {
        return null;
    }
}
