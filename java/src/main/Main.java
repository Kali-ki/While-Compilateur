import java.io.IOException;
import java.util.List;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenRewriteStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeAdaptor;
import org.antlr.runtime.tree.TreeAdaptor;

import Antlr.gwhileLexer;
import Antlr.gwhileParser;
import CompilationException.CompilationException;
import SymbolsTable.ParserAST;
import SymbolsTable.SymbolTable;
import ThreeAddressCode.ThreeAddressCodeGenerator;
import ThreeAddressToCpp.ThreeAddressToCppGenerator;

public class Main {

    static final TreeAdaptor adaptor = new CommonTreeAdaptor() {
        public Object create(Token payload) {
            return new CommonTree(payload);
        }
    };

    static final boolean EXPORT_MODE = false;

    /**
     * Main du compilateur
     * args[0] : chemin du fichier source .while *obligatoire*
     * args[1] : affichage de l'AST *optionnel*
     * args[2] : affichage de la table des symboles *optionnel*
     * args[3] : affichage du code 3 adresses *optionnel*
     * @param args
     */
    public static void main(String args[]) {

        // paramètres par défaut lors du developpement
        if(!EXPORT_MODE){
            String arguments [] = {"compilateur/program.while","0","0","0"};
            args = arguments;
        }
        if(args.length == 0){
            System.out.println("Il faut un fichier source .while");
            return;
        }else if(args.length > 4){
            System.out.println("Trop d'arguments");
            return;
        }

        String pathWhileFile = args[0];
        boolean displayAST = args.length > 1 ? Integer.parseInt(args[1]) == 1 : false;
        boolean displayST = args.length > 2 ?  Integer.parseInt(args[2]) == 1 : false;
        boolean display3A = args.length > 3 ? Integer.parseInt(args[3]) == 1 : false;

        try {
            boolean assertion = pathWhileFile.endsWith(".while");
            if (!assertion){
                System.out.println("Le fichier source doit être en \".while\"");
                return;
            }  
            ANTLRFileStream fs = new ANTLRFileStream(pathWhileFile);

            // Analyse syntaxique et construction de l'AST
            gwhileLexer lex = new gwhileLexer(fs);
            TokenRewriteStream tokens = new TokenRewriteStream(lex);
            gwhileParser grammar = new gwhileParser(tokens);
            grammar.setTreeAdaptor(adaptor);
            gwhileParser.program_return ret = grammar.program();
            CommonTree tree = (CommonTree) ret.getTree();

            // Affichage de l'AST
            if (displayAST) {
                printTree(tree, 0);
            }

            ParserAST parserAST = new ParserAST(tree);
            SymbolTable st = parserAST.getSymbolTable();

            // Affichage de la table des symboles
            if (displayST) {
                st.display();
            }

            // Génération du code 3 adressses
            ThreeAddressCodeGenerator generator = new ThreeAddressCodeGenerator();
            List<String> code3a = generator.generate(tree);

            // Affichage du code 3 adresses
            if (display3A) {
                for (String line : code3a) {
                    System.out.println(line);
                }
            }

            // Conversion 3A vers code en langage cible (c++ dans notre cas)
            ThreeAddressToCppGenerator cppGenerator = new ThreeAddressToCppGenerator(code3a);
            if (EXPORT_MODE) {
                cppGenerator.writeCpp("");
            } else {
                //Tools.Tools.writeFile("Java/program.asm", code3a);
                cppGenerator.writeCpp();
                System.out.println(
                    "Exécuter le code C++ généré à l'aide de la commande suivante :\n"+
                    //"g++ -o program program.cpp && ./program && rm program"
                    "g++ -o java/program java/program.cpp && java/./program && rm java/program"
                );
            }

        } catch (IOException e) {
            System.out.println(e.toString());
        } catch (RecognitionException e) {
            System.out.println(e.toString());
        } catch (CompilationException e) {
            System.out.println(e.toString());
        } catch (Exception e) {
           System.out.println(e.toString());
        }

    }

    /**
     * Affichage de l'AST
     * @param t
     * @param indent
     */
    public static void printTree(CommonTree t, int indent) {
        if (t != null) {
            StringBuffer sb = new StringBuffer(indent);

            if (t.getParent() == null) {
                System.out.println(sb.toString() + t.getText().toString());
            }
            for (int i = 0; i < indent; i++)
                sb = sb.append("   ");
            for (int i = 0; i < t.getChildCount(); i++) {
                System.out.println(sb.toString() + t.getChild(i).toString());
                printTree((CommonTree) t.getChild(i), indent + 1);
            }
        }
    }

}