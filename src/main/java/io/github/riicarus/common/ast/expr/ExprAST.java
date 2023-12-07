package io.github.riicarus.common.ast.expr;

import io.github.riicarus.common.data.AbstractAST;
import io.github.riicarus.common.data.AstType;

/**
 * 表达式 AST
 *
 * @author Riicarus
 * @create 2023-12-6 13:46
 * @since 1.0.0
 */
public abstract class ExprAST<T> extends AbstractAST<T> {
    public ExprAST(AstType type) {
        super(type);
    }
}
