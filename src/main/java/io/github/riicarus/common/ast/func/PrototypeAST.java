package io.github.riicarus.common.ast.func;

import io.github.riicarus.common.data.AbstractAST;

import java.util.List;

/**
 * 函数原型 AST
 *
 * @author Riicarus
 * @create 2023-12-7 12:30
 * @since 1.0.0
 */
public class PrototypeAST<T> extends AbstractAST<T> {

    protected String name;
    protected List<String> args;

    @Override
    public T compute() {
        return null;
    }
}
