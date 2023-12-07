package io.github.riicarus.common.ast.expr;

import io.github.riicarus.common.data.AstType;
import io.github.riicarus.common.data.BasicAstType;

/**
 * 变量表达式 AST
 *
 * @author Riicarus
 * @create 2023-12-7 12:15
 * @since 1.0.0
 */
public class VariableExprAST<T> extends ExprAST<T> {

    protected final String name;
    protected final ValueExprAST<T> valAST;

    public VariableExprAST(AstType type, String name, ValueExprAST<T> valAST) {
        super(type);
        this.name = name;
        this.valAST = valAST;
    }

    public VariableExprAST(String name, ValueExprAST<T> valAST) {
        super(BasicAstType.VAR);
        this.name = name;
        this.valAST = valAST;
    }

    @Override
    public T execute() {
        return valAST.execute();
    }

    @Override
    public String toTreeString(int level) {
        StringBuilder sb = new StringBuilder();
        String t = "\t".repeat(Math.max(0, level - 1));
        String link = level == 0 ? "" : "|--- ";

        if (level != 0) {
            sb.append("\r\n");
        }

        sb.append(t).append(link).append(name).append("<").append(type).append(">")
                .append(valAST.toTreeString(level + 1));

        return sb.toString();
    }

    @Override
    public String toString() {
        return toTreeString(0);
    }
}
