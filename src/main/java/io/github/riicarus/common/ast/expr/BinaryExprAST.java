package io.github.riicarus.common.ast.expr;

import io.github.riicarus.common.data.AbstractAST;

/**
 * 二元运算符表达式 AST
 *
 * @author Riicarus
 * @create 2023-12-6 13:46
 * @since 1.0.0
 */
public class BinaryExprAST<L, R, T> extends AbstractAST<T> {

    protected String op;
    protected ExprAST<L> left;
    protected ExprAST<R> right;

    @Override
    public T compute() {
        return null;
    }
}
