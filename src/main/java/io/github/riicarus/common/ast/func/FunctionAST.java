package io.github.riicarus.common.ast.func;

import io.github.riicarus.common.ast.expr.ExprAST;
import io.github.riicarus.common.data.AbstractAST;

/**
 * 函数定义表达式
 *
 * @author Riicarus
 * @create 2023-12-7 12:31
 * @since 1.0.0
 */
public class FunctionAST<T> extends AbstractAST<T> {

    protected PrototypeAST<T> proto;
    protected ExprAST<T> body;

    @Override
    public T compute() {
        return body.compute();
    }
}
