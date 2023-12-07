package io.github.riicarus.common.ast.func;

import io.github.riicarus.common.data.AbstractAST;
import io.github.riicarus.common.data.AstType;

import java.util.List;

/**
 * 函数原型 AST
 *
 * @author Riicarus
 * @create 2023-12-7 12:30
 * @since 1.0.0
 */
public class PrototypeAST<T> extends AbstractAST<T> {

    protected final String name;
    protected final List<String> args;

    public PrototypeAST(AstType type, String name, List<String> args) {
        super(type);
        this.name = name;
        this.args = args;
    }

    @Override
    public String toTreeString(int level) {
        return null;
    }
}
