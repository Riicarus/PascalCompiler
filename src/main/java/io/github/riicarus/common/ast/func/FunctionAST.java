package io.github.riicarus.common.ast.func;

import io.github.riicarus.common.ast.expr.ExprAST;
import io.github.riicarus.common.data.AbstractAST;
import io.github.riicarus.common.data.AstType;

/**
 * 函数定义表达式
 *
 * @author Riicarus
 * @create 2023-12-7 12:31
 * @since 1.0.0
 */
public class FunctionAST<T> extends AbstractAST<T> {

    protected final PrototypeAST<T> proto;
    protected final ExprAST<T> body;

    public FunctionAST(AstType type, PrototypeAST<T> proto, ExprAST<T> body) {
        super(type);
        this.proto = proto;
        this.body = body;
    }

    @Override
    public T execute() {
        return null;
    }

    @Override
    public String toTreeString(int level) {
        return null;
    }
}
