package io.github.riicarus.common.ast.expr;

import io.github.riicarus.common.data.AstType;

import java.util.ArrayList;
import java.util.List;

/**
 * 函数调用表达式 AST
 *
 * @author Riicarus
 * @create 2023-12-7 12:26
 * @since 1.0.0
 */
public class CallExprAST<T> extends ExprAST<T> {

    protected final String callFuncName;
    protected final List<ExprAST<?>> args = new ArrayList<>();

    public CallExprAST(AstType type, String callFuncName, List<ExprAST<?>> args) {
        super(type);
        this.callFuncName = callFuncName;
        this.args.addAll(args);
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
