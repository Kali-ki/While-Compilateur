import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenRewriteStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeAdaptor;
import org.antlr.runtime.tree.TreeAdaptor;
import org.junit.Test;

import Antlr.gwhileLexer;
import Antlr.gwhileParser;

import CompilationException.CompilationException;
import SymbolsTable.ParserAST;

public class CompilateurTest {
    
    // Fail Test

    @Test(expected=CompilationException.class) // Oracle du test
    public void testFonctionDejaDeclaree() throws CompilationException{
        baseTest("fonctionDejaDeclare.while");
    }

    @Test(expected=CompilationException.class) // Oracle du test
    public void testMainNonDeclaree() throws CompilationException{
        baseTest("mainNonDeclareFonction.while");
    }

    @Test(expected=CompilationException.class) // Oracle du test
    public void nombreExpressionSupNombreVar() throws CompilationException{
        baseTest("nombreExpressionSupNombreVar.while");
    }

    @Test(expected=CompilationException.class) // Oracle du test
    public void testFonctionNonDeclaree() throws CompilationException{
        baseTest("nonDeclareFonction.while");
    }

    @Test(expected=CompilationException.class) // Oracle du test
    public void testTropArgumentFonction() throws CompilationException{
        baseTest("tropArgumentFonction.while");
    }

    @Test(expected=CompilationException.class) // Oracle du test
    public void testNombreArgumentHd() throws CompilationException{
        baseTest("tropArgumentHd.while");
    }

    @Test(expected=CompilationException.class) // Oracle du test
    public void testNombreArgumentTl() throws CompilationException{
        baseTest("tropArgumentTl.while");
    }

    @Test(expected=CompilationException.class) // Oracle du test
    public void testDeclarationVariableRetourne() throws CompilationException{
        baseTest("variableSortieNonDeclare.while");
    }

    // Success Test

    @Test
    public void testAppelleFonction() throws CompilationException{
        baseTest("shouldWorks_AppelleFonction.while");

        // Oracle du test ; Si le test ne plante pas, il est considéré comme réussi
        assertEquals(1, 1);
    }

    @Test
    public void testAppelleFonctionSansArugment() throws CompilationException{
        baseTest("shouldWorks_AppelleFonctionSansArgument.while");

        // Oracle du test ; Si le test ne plante pas, il est considéré comme réussi
        assertEquals(1, 1);
    }

    @Test
    public void testBasiqueMain() throws CompilationException{
        baseTest("shouldWorks_BasiqueMain.while");

        // Oracle du test ; Si le test ne plante pas, il est considéré comme réussi
        assertEquals(1, 1);
    }

    @Test
    public void testConsImbriques() throws CompilationException{
        baseTest("shouldWorks_BasiqueMainAvecConsImbrique.while");

        // Oracle du test ; Si le test ne plante pas, il est considéré comme réussi
        assertEquals(1, 1);
    }

    @Test
    public void testString() throws CompilationException{
        baseTest("shouldWorks_BasiqueMainAvecString.while");

        // Oracle du test ; Si le test ne plante pas, il est considéré comme réussi
        assertEquals(1, 1);
    }

    @Test
    public void testString2() throws CompilationException{
        baseTest("shouldWorks_BasiqueMainAvecString2.while");

        // Oracle du test ; Si le test ne plante pas, il est considéré comme réussi
        assertEquals(1, 1);
    }

    @Test
    public void testCommentaire() throws CompilationException{
        baseTest("shouldWorks_CommentaireSimple.while");

        // Oracle du test ; Si le test ne plante pas, il est considéré comme réussi
        assertEquals(1, 1);
    }

    @Test
    public void testCommentaireMultiple() throws CompilationException{
        baseTest("shouldWorks_CommentaireMultiple.while");

        // Oracle du test ; Si le test ne plante pas, il est considéré comme réussi
        assertEquals(1, 1);
    }
    
    public void baseTest(String file) throws CompilationException{
        
        try {
            // Initialisation du test
            ANTLRFileStream fs = new ANTLRFileStream(file);
            gwhileLexer lex = new gwhileLexer(fs);
            TokenRewriteStream tokens = new TokenRewriteStream(lex);
            gwhileParser grammar = new gwhileParser(tokens);
            grammar.setTreeAdaptor(adaptor);
            gwhileParser.program_return ret = grammar.program();
            CommonTree tree = (CommonTree) ret.getTree();
            ParserAST parserAST = new ParserAST(tree);

            // Execution du test
            parserAST.getSymbolTable();

        }
        catch(IOException e){}
        catch(RecognitionException e){}

    }

    static final TreeAdaptor adaptor = new CommonTreeAdaptor() {
        public Object create(Token payload) {
            return new CommonTree(payload);
        }
    };

}
