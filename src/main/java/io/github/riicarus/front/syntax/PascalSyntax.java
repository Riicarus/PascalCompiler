package io.github.riicarus.front.syntax;

import io.github.riicarus.common.ast.*;
import io.github.riicarus.common.data.ast.ASTCreator;
import io.github.riicarus.common.data.ast.ASTNode;
import io.github.riicarus.front.syntax.ll1.LL1SyntaxInlineDefiner;
import io.github.riicarus.front.syntax.ll1.LL1SyntaxSymbol;
import io.github.riicarus.front.syntax.ll1.LL1Syntaxer;

import java.util.List;
import java.util.Set;

/**
 * 类 Pascal 文法定义
 *
 * @author Riicarus
 * @create 2023-12-9 15:10
 * @since 1.0.0
 */
public class PascalSyntax {

    private static final SyntaxSymbol eps = new LL1SyntaxSymbol("eps", SyntaxSymbolType.ASST, true);
    private static final SyntaxSymbol begin = new LL1SyntaxSymbol("begin", SyntaxSymbolType.OP, true);
    private static final SyntaxSymbol end = new LL1SyntaxSymbol("end", SyntaxSymbolType.OP, true);
    private static final SyntaxSymbol integer = new LL1SyntaxSymbol("integer", SyntaxSymbolType.OP, true);
    private static final SyntaxSymbol identifier = new LL1SyntaxSymbol("identifier", SyntaxSymbolType.OP, true);
    private static final SyntaxSymbol function = new LL1SyntaxSymbol("function", SyntaxSymbolType.OP, true);
    private static final SyntaxSymbol lParen = new LL1SyntaxSymbol("(", SyntaxSymbolType.OP, true);
    private static final SyntaxSymbol rParen = new LL1SyntaxSymbol(")", SyntaxSymbolType.OP, true);
    private static final SyntaxSymbol semicolon = new LL1SyntaxSymbol(";", SyntaxSymbolType.OP, true);
    private static final SyntaxSymbol read = new LL1SyntaxSymbol("read", SyntaxSymbolType.OP, true);
    private static final SyntaxSymbol write = new LL1SyntaxSymbol("write", SyntaxSymbolType.OP, true);
    private static final SyntaxSymbol assign = new LL1SyntaxSymbol(":=", SyntaxSymbolType.OP, true);
    private static final SyntaxSymbol times = new LL1SyntaxSymbol("*", SyntaxSymbolType.OP, true);
    private static final SyntaxSymbol minus = new LL1SyntaxSymbol("-", SyntaxSymbolType.OP, true);
    private static final SyntaxSymbol constant = new LL1SyntaxSymbol("constant", SyntaxSymbolType.OP, true);
    private static final SyntaxSymbol _if = new LL1SyntaxSymbol("if", SyntaxSymbolType.OP, true);
    private static final SyntaxSymbol _then = new LL1SyntaxSymbol("then", SyntaxSymbolType.OP, true);
    private static final SyntaxSymbol _else = new LL1SyntaxSymbol("else", SyntaxSymbolType.OP, true);
    private static final SyntaxSymbol lt = new LL1SyntaxSymbol("<", SyntaxSymbolType.OP, true);
    private static final SyntaxSymbol le = new LL1SyntaxSymbol("<=", SyntaxSymbolType.OP, true);
    private static final SyntaxSymbol gt = new LL1SyntaxSymbol(">", SyntaxSymbolType.OP, true);
    private static final SyntaxSymbol ge = new LL1SyntaxSymbol(">=", SyntaxSymbolType.OP, true);
    private static final SyntaxSymbol eq = new LL1SyntaxSymbol("=", SyntaxSymbolType.OP, true);
    private static final SyntaxSymbol ne = new LL1SyntaxSymbol("<>", SyntaxSymbolType.OP, true);

    private static final SyntaxSymbol P = new LL1SyntaxSymbol("P", SyntaxSymbolType.EXPR, false);
    private static final SyntaxSymbol SP = new LL1SyntaxSymbol("SP", SyntaxSymbolType.EXPR, false);
    private static final SyntaxSymbol DST = new LL1SyntaxSymbol("DST", SyntaxSymbolType.EXPR, false);
    private static final SyntaxSymbol DS = new LL1SyntaxSymbol("DS", SyntaxSymbolType.EXPR, false);
    private static final SyntaxSymbol VDorFDS = new LL1SyntaxSymbol("VDorFDS", SyntaxSymbolType.EXPR, false);
    private static final SyntaxSymbol V = new LL1SyntaxSymbol("V", SyntaxSymbolType.EXPR, false);
    private static final SyntaxSymbol Id = new LL1SyntaxSymbol("Id", SyntaxSymbolType.EXPR, false);
    private static final SyntaxSymbol A = new LL1SyntaxSymbol("A", SyntaxSymbolType.EXPR, false);
    private static final SyntaxSymbol FB = new LL1SyntaxSymbol("FB", SyntaxSymbolType.EXPR, false);
    private static final SyntaxSymbol EST = new LL1SyntaxSymbol("EST", SyntaxSymbolType.EXPR, false);
    private static final SyntaxSymbol ES = new LL1SyntaxSymbol("ES", SyntaxSymbolType.EXPR, false);
    private static final SyntaxSymbol RS = new LL1SyntaxSymbol("RS", SyntaxSymbolType.EXPR, false);
    private static final SyntaxSymbol WS = new LL1SyntaxSymbol("WS", SyntaxSymbolType.EXPR, false);
    private static final SyntaxSymbol AS = new LL1SyntaxSymbol("AS", SyntaxSymbolType.EXPR, false);
    private static final SyntaxSymbol AE = new LL1SyntaxSymbol("AE", SyntaxSymbolType.EXPR, false);
    private static final SyntaxSymbol AE_P = new LL1SyntaxSymbol("AE'", SyntaxSymbolType.EXPR, false);
    private static final SyntaxSymbol I = new LL1SyntaxSymbol("I", SyntaxSymbolType.EXPR, false);
    private static final SyntaxSymbol I_P = new LL1SyntaxSymbol("I'", SyntaxSymbolType.EXPR, false);
    private static final SyntaxSymbol F = new LL1SyntaxSymbol("F", SyntaxSymbolType.EXPR, false);
    private static final SyntaxSymbol VorFC = new LL1SyntaxSymbol("VorFC", SyntaxSymbolType.EXPR, false);
    private static final SyntaxSymbol VorFCS = new LL1SyntaxSymbol("VorFCS", SyntaxSymbolType.EXPR, false);
    private static final SyntaxSymbol C = new LL1SyntaxSymbol("C", SyntaxSymbolType.EXPR, false);
    private static final SyntaxSymbol CS = new LL1SyntaxSymbol("CS", SyntaxSymbolType.EXPR, false);
    private static final SyntaxSymbol CE = new LL1SyntaxSymbol("CE", SyntaxSymbolType.EXPR, false);
    private static final SyntaxSymbol RO = new LL1SyntaxSymbol("RO", SyntaxSymbolType.EXPR, false);

    private static final ASTCreator<ASTNode> epsConstructor = null;
    private static final ASTCreator<ASTNode> beginConstructor = null;
    private static final ASTCreator<ASTNode> endConstructor = null;
    private static final ASTCreator<ASTNode> integerConstructor = null;
    private static final ASTCreator<ASTNode> identifierConstructor = null;
    private static final ASTCreator<ASTNode> functionConstructor = null;
    private static final ASTCreator<ASTNode> lParenConstructor = null;
    private static final ASTCreator<ASTNode> rParenConstructor = null;
    private static final ASTCreator<ASTNode> semicolonConstructor = null;
    private static final ASTCreator<ASTNode> readConstructor = null;
    private static final ASTCreator<ASTNode> writeConstructor = null;
    private static final ASTCreator<ASTNode> assignConstructor = null;
    private static final ASTCreator<ASTNode> timesConstructor = null;
    private static final ASTCreator<ASTNode> minusConstructor = null;
    private static final ASTCreator<ASTNode> constantConstructor = null;
    private static final ASTCreator<ASTNode> ifConstructor = null;
    private static final ASTCreator<ASTNode> thenConstructor = null;
    private static final ASTCreator<ASTNode> elseConstructor = null;
    private static final ASTCreator<ASTNode> ltConstructor = null;
    private static final ASTCreator<ASTNode> leConstructor = null;
    private static final ASTCreator<ASTNode> gtConstructor = null;
    private static final ASTCreator<ASTNode> geConstructor = null;
    private static final ASTCreator<ASTNode> eqConstructor = null;
    private static final ASTCreator<ASTNode> neConstructor = null;

    private static final LL1SyntaxInlineDefiner definer = new LL1SyntaxInlineDefiner(eps, P);

    public static final Syntaxer SYNTAXER;

    static {
        definer.addSymbols(
                Set.of(
                        eps, begin, end, integer, identifier,
                        function, lParen, rParen, semicolon,
                        read, write, assign, times, minus, constant,
                        _if, _then, _else,
                        lt, le, gt, ge, eq, ne
                )
        );
        definer.addSymbols(
                Set.of(
                        P, SP,
                        DST, DS,
                        VDorFDS, V, Id,
                        A, FB,
                        EST, ES,
                        RS, WS, AS,
                        AE, AE_P,
                        I, I_P,
                        F, VorFC, VorFCS, C, CS, CE, RO
                )
        );

        definer.addProduction("P", List.of("SP"), ProgramNode.CREATOR);
        definer.addProduction("SP", List.of("begin", "DST", "EST", "end"), SubProgramNode.CREATOR);
        definer.addProduction("DST", List.of("DS", ";", "DST"), DSTToDSNode.CREATOR);
        definer.addProduction("DST", List.of("eps"), EmptyDSTNode.CREATOR);
        definer.addProduction("DS", List.of("integer", "VDorFDS"), DSNode.CREATOR);
        definer.addProduction("VDorFDS", List.of("V"), VDSuffixNode.CREATOR);
        definer.addProduction("VDorFDS", List.of("function", "Id", "(", "A", ")", ";", "FB"), FDSuffixNode.CREATOR);
        definer.addProduction("V", List.of("Id"), VNode.CREATOR);
        definer.addProduction("Id", List.of("identifier"), IdNode.CREATOR);
        definer.addProduction("A", List.of("V"), ANode.CREATOR);
        definer.addProduction("FB", List.of("begin", "DST", "EST", "end"), FBNode.CREATOR);
        definer.addProduction("EST", List.of("ES", ";", "EST"), ESTToESNode.CREATOR);
        definer.addProduction("EST", List.of("eps"), EmptyESTNode.CREATOR);
        definer.addProduction("ES", List.of("RS"), ESToRSNode.CREATOR);
        definer.addProduction("ES", List.of("WS"), ESToWSNode.CREATOR);
        definer.addProduction("ES", List.of("AS"), ESToASNode.CREATOR);
        definer.addProduction("ES", List.of("CS"), ESToCSNode.CREATOR);
        definer.addProduction("RS", List.of("read", "(", "V", ")"), RSNode.CREATOR);
        definer.addProduction("WS", List.of("write", "(", "V", ")"), WSNode.CREATOR);
        definer.addProduction("AS", List.of("V", ":=", "AE"), ASNode.CREATOR);
        definer.addProduction("AE", List.of("I", "AE'"), AENode.CREATOR);
        definer.addProduction("AE'", List.of("-", "I", "AE'"), AEPlusToMinusNode.CREATOR);
        definer.addProduction("AE'", List.of("eps"), EmptyAEPlusNode.CREATOR);
        definer.addProduction("I", List.of("F", "I'"), INode.CREATOR);
        definer.addProduction("I'", List.of("*", "F", "I'"), IPlusToTimesNode.CREATOR);
        definer.addProduction("I'", List.of("eps"), EmptyIPlusNode.CREATOR);
        definer.addProduction("F", List.of("VorFC"), FToVorFCNode.CREATOR);
        definer.addProduction("F", List.of("C"), FToCNode.CREATOR);
        definer.addProduction("VorFC", List.of("Id", "VorFCS"), VorFCNode.CREATOR);
        definer.addProduction("VorFCS", List.of("(", "AE", ")"), FCSuffixNode.CREATOR);
        definer.addProduction("VorFCS", List.of("eps"), EmptyVSuffixNode.CREATOR);
        definer.addProduction("C", List.of("constant"), CNode.CREATOR);
        definer.addProduction("CS", List.of("if", "CE", "then", "ES", "else", "ES"), CSNode.CREATOR);
        definer.addProduction("CE", List.of("AE", "RO", "AE"), CENode.CREATOR);
        definer.addProduction("RO", List.of("<"), LTNode.CREATOR);
        definer.addProduction("RO", List.of("<="), LENode.CREATOR);
        definer.addProduction("RO", List.of(">"), GTNode.CREATOR);
        definer.addProduction("RO", List.of(">="), GENode.CREATOR);
        definer.addProduction("RO", List.of("="), EQNode.CREATOR);
        definer.addProduction("RO", List.of("<>"), NENode.CREATOR);

        SYNTAXER = new LL1Syntaxer(definer);
    }

}
