package SymbolsTable;

import org.antlr.runtime.tree.CommonTree;

import CompilationException.CompilationException;

/**
 * Classe pour parser l'AST et construit la table des symboles
 */
public class ParserAST {

    // --- Attributs ------------------------------------------------------------------------------

    // L'AST
    private CommonTree tree;

    // Les différents types de noeuds
    private final String FONCTION_DEF = "FONCTION_DEF";
    private final String INPUTSUB = "INPUTSUB";
    private final String OUTPUT = "OUTPUT";
    private final String VARIABLE_DEF = "VARIABLE_DEF";
    private final String VARIABLE = "VARIABLE";
    private final String FUNCTION = "FUNCTION";
    private final String STRING = "STRING";
    private final String CONS = "CONS";
    private final String TL = "TL";
    private final String HD = "HD";
    private final String LIST = "LIST";
    private final String nil = "nil";
    private final String nop = "nop";

    // --- Constructeur ---------------------------------------------------------------------------
    
    public ParserAST(CommonTree tree) {
        this.tree = tree;
    }

    // --- Méthodes -------------------------------------------------------------------------------

    /**
     * Construit la table des symboles
     * @return la table des symboles
     * @throws CompilationException
     */
    public SymbolTable getSymbolTable() throws CompilationException {
        
        SymbolTable symbolTable = new SymbolTable();

        visit(tree, symbolTable);

        // On vérifie que la fonction main est déclarée
        if(!symbolTable.hasMainFunction()){
            throw new CompilationException("ERREUR : La fonction main n'est pas déclarée");
        }

        return symbolTable;

    }

    /**
     * @param tree the tree
     * @throws CompilationException
     */
    private void visit(CommonTree tree, SymbolTable symbolTable) throws CompilationException {

        // On parcourt tous les enfants du noeud
        for(int i = 0; i < tree.getChildCount(); i++) {

            CommonTree child = (CommonTree) tree.getChild(i);

            String val = child.getText();

            // On regarde le type de noeud

            // Si c'est la déclaration d'une fonction
            if(val.equals(FONCTION_DEF)){

                // On récupère le nombre d'arguments de la fonction & son nom
                int numberOfArguments;

                if(child.getChild(1).getChild(0).getText().equals(INPUTSUB)){
                    numberOfArguments = child.getChild(1).getChild(0).getChildCount();
                }else{
                    numberOfArguments = 0;
                }
                
                String nameFunction = child.getChild(0).getText();
                
                // On vérifie que la fonction n'est pas déclarée
                if(symbolTable.containsFunction(nameFunction)){
                    throw new CompilationException("ERREUR : La fonction " + nameFunction + " est déjà déclarée ; ligne " + child.getLine());
                }

                // On ajoute la fonction dans la table des symboles
                symbolTable.putFunction(nameFunction, numberOfArguments);

                // On crée une nouvelle table des symboles pour la fonction
                SymbolTable symbolTable_child = new SymbolTable(symbolTable.getFunctionsTable());
                symbolTable.addChild(symbolTable_child);

                // On visite le noeud
                visit(child, symbolTable_child);
            
            // Si c'est une liste d'arguments de fonction
            }else if(val.equals(INPUTSUB)){

                // On ajoute les arguments dans la table des symboles
                for(int j = 0; j < child.getChildCount(); j++){
                    String name = child.getChild(j).getText();
                    symbolTable.putSymbol(name, null);
                }

            }

            // Si c'est une variable de sortie
            else if(val.equals(OUTPUT)){

                // On vérifie que les variables de sortie sont déclarées
                for(int j = 0 ; j < child.getChildCount() ; j++){
                    String output = child.getChild(j).getText();
                    if(!symbolTable.containsSymbol(output)){
                        throw new CompilationException("ERREUR : Variable de sortie " + output + " non déclarée ; ligne " + child.getLine());
                    }
                }

            }

            // Si c'est la déclaration d'une variable
            else if(val.equals(VARIABLE_DEF)){

                CommonTree names = (CommonTree) child.getChild(0);
                CommonTree values = (CommonTree)child.getChild(1);

                int names_size = names.getChildCount();
                int values_size = values.getChildCount();

                if(values_size > names_size){
                    throw new CompilationException("ERREUR : Trop d'expressions ; ligne " + child.getLine());
                }else{
                    for(int k = 0 ; k < names_size ; k++){
                        String name = names.getChild(k).getText();
                        if(k < values_size){
                            Object value = parseExpression((CommonTree) values.getChild(k), symbolTable);
                            if(!symbolTable.containsSymbol(name)){
                                symbolTable.putSymbol(name, value);
                            }else{
                                symbolTable.setSymbolValue(name, value);
                            }
                        }else{
                            if(!symbolTable.containsSymbol(name)){
                                symbolTable.putSymbol(name, 0);
                            }else{
                                symbolTable.setSymbolValue(name, 0);
                            }
                            
                        }
                    }
                }

            }

            else if(val.equals(VARIABLE)){

                String secondChild = child.getChild(0).getText();
    
                // On vérifie que la variable est déclarée
                if(!symbolTable.containsSymbol(secondChild)){
                    System.out.println("WARNING : La variable " + secondChild + " n'est pas déclarée. Considère comme nil ; ligne " + child.getLine());
                    symbolTable.putSymbol(secondChild, 0);
                }
    
            }

            else if(val.equals(FUNCTION)){

                String name = child.getChild(0).getText();

                // On vérifie que la fonction est déclarée
                if(!symbolTable.containsFunction(name)){
                    throw new CompilationException("ERREUR : Fonction " + name + " non déclarée ; ligne " + child.getLine());
                }

                // On vérifie le nombre d'arguments
                int numberOfArguments = child.getChildCount() - 1;
                if(numberOfArguments != symbolTable.getNumberArguments(name)){
                    throw new CompilationException("ERREUR : Nombre d'arguments de la fonction " + name + " incorrect ; ligne " + child.getLine() + ".");
                }

                // On vérifie que les arguments sont des variables déclarées
                for(int j = 1 ; j < child.getChildCount() ; j++){

                    String argument = child.getChild(j).getText();

                    if(!isExpression(argument)){
                        throw new CompilationException("ERREUR : Fonction " + name + "n'ai pas suivi par une/des expression.s. ; ligne " + child.getLine());
                    }
                    
                }

            }

            else if(val.equals(nop)){
                // On ne fait rien
            }

            // Si c'est un autre noeud
            else{

                int nombreArguments = child.getChildCount();

                // Si c'est un cons
                if(val.equals(CONS)){
    
                    // S'il y a des arguments
                    if(nombreArguments != 0){
                        for(int j = 0; j < nombreArguments; j++){
    
                            if(!isExpression(child.getChild(j).getText())){
                                throw new CompilationException("ERREUR : Mot clé cons doit être suivi par des expressions ; ligne " + child.getLine());
                            }
                            
                        }
                    }
    
                }

                // Si c'est un tl
                else if(val.equals(TL)){

                    // On vérifie que le nombre d'arguments est correct
                    if(nombreArguments != 1){
                        throw new CompilationException("ERREUR : Nombre d'arguments incorrect pour le clé tl ; ligne " + child.getLine());
                    }

                    // On vérifie que l'argument est correct
                    if(!isExpression(child.getChild(0).getText())){
                        throw new CompilationException("ERREUR : Mot clé tl doit être suivi par une expression ; ligne " + child.getLine());
                    }

                }
                
                // Si c'est un hd
                else if(val.equals(HD)){

                    // On vérifie que le nombre d'arguments est correct
                    if(nombreArguments != 1){
                        throw new CompilationException("ERREUR : Nombre d'arguments incorrect pour le clé tl ; ligne " + child.getLine());
                    }

                    // On vérifie que l'argument est correct
                    if(!isExpression(child.getChild(0).getText())){
                        throw new CompilationException("ERREUR : Mot clé hd doit être suivi par une expression ; ligne " + child.getLine());
                    }

                }

                // Si c'est une list
                else if(val.equals(LIST)){
                    
                    // S'il y a des argument alors on vérifie qu'ils sont corrects
                    if(nombreArguments == 0){
                        for(int j = 0; j < nombreArguments; j++){
                            if(!isExpression(child.getChild(j).getText())){
                                throw new CompilationException("ERREUR : Mot clé list doit être suivi par des expressions ; ligne " + child.getLine());
                            }
                        }
                    }

                }

                visit(child, symbolTable);
            }
            
        }
    }

    /**
     * Parse une expression et renvoie sa valeur
     * @param expression
     * @return
     * @throws CompilationException
     */
    private Object parseExpression(CommonTree expression, SymbolTable symbolTable) throws CompilationException {

        String firstChild = expression.getText();

        // Si c'est "nil" renvoie pour valeur 0
        if(firstChild.equals(nil)){
            return 0;
        }

        // Si c'est une fonction
        else if(firstChild.equals(FUNCTION)){

            String name = expression.getChild(0).getText();

            // On vérifie que la fonction est déclarée
            if(!symbolTable.containsFunction(name)){
                throw new CompilationException("ERREUR : Fonction " + name + " non déclarée ; ligne " + expression.getLine());
            }

            // On vérifie le nombre d'arguments
            int numberOfArguments = expression.getChildCount() - 1;
            if(numberOfArguments != symbolTable.getNumberArguments(name)){
                throw new CompilationException("ERREUR : Nombre d'arguments de la fonction " + name + " incorrect ; ligne " + expression.getLine() + ".");
            }

            // On vérifie que les arguments sont des variables déclarées
            for(int j = 1 ; j < expression.getChildCount() ; j++){

                String argument = expression.getChild(j).getText();

                if(!isExpression(argument)){
                    throw new CompilationException("ERREUR : Fonction " + name + "n'ai pas suivi par une/des expression.s. ; ligne " + expression.getLine());
                }
                
            }
            
        }

        // Si c'est une variable
        else if(firstChild.equals(VARIABLE)){

            String secondChild = expression.getChild(0).getText();

            // On vérifie que la variable est déclarée
            if(!symbolTable.containsSymbol(secondChild)){
                System.out.println("WARNING : La variable " + secondChild + " n'est pas déclarée. Considère comme nil ; ligne " + expression.getLine());
                return 0;
            }

            return null;

        }

        else if(firstChild.equals(STRING)){

            return expression.getChild(0).getText();

        }

        // Si c'est un opérateur
        else {

            int nombreArguments = expression.getChildCount();

            // Si c'est un cons
            if(firstChild.equals(CONS)){

                // S'il n'y aucun argument
                if(nombreArguments == 0){
                    return 0;
                // S'il y a au minimum un argument, on vérifie que ce sont des variables
                }else{
                    for(int i = 0; i < nombreArguments; i++){

                        if(!isExpression(expression.getChild(i).getText())){
                            throw new CompilationException("ERREUR : Mot clé cons doit être suivi par des expressions ; ligne " + expression.getLine());
                        }
                        
                    }
                }

            }
            
            // Si c'est un tl
            else if(firstChild.equals(TL)){

                // On vérifie que le nombre d'arguments est correct
                if(nombreArguments != 1){
                    throw new CompilationException("ERREUR : Nombre d'arguments incorrect pour le clé tl ; ligne " + expression.getLine());
                }

                // On vérifie que l'argument est correct
                if(!isExpression(expression.getChild(0).getText())){
                    throw new CompilationException("ERREUR : Mot clé cons doit être suivi par une expression ; ligne " + expression.getLine());
                }

            }   
            
            // Si c'est un hd
            else if(firstChild.equals(HD)){

                // On vérifie que le nombre d'arguments est correct
                if(nombreArguments != 1){
                    throw new CompilationException("ERREUR : Nombre d'arguments incorrect pour le clé tl ; ligne " + expression.getLine());
                }

                // On vérifie que l'argument est correct
                if(!isExpression(expression.getChild(0).getText())){
                    throw new CompilationException("ERREUR : Mot clé cons doit être suivi par une expression ; ligne " + expression.getLine());
                }

            }
            
            // Si c'est une list
            else if(firstChild.equals(LIST)){
                
                // S'il n'y a aucun argument alors on renvoie 0
                if(nombreArguments == 0){
                    return 0;
                // S'il y a au minimum un argument, on vérifie que ce sont des variables
                }else{
                    for(int i = 0; i < nombreArguments; i++){
                        if(!isExpression(expression.getChild(i).getText())){
                            throw new CompilationException("ERREUR : Mot clé list doit être suivi par des expressions ; ligne " + expression.getLine());
                        }
                    }
                }

            }
            
            // On finit en parcourant de manière récursive les arguments
            for(int i = 0; i < nombreArguments ; i++){
                parseExpression((CommonTree) expression.getChild(i), symbolTable);
            }

        }

        // Ne devrait jamais arriver
        return null;

    }

    private boolean isExpression(String text) {
        return text.equals(nil) || text.equals(CONS) || text.equals(TL) || text.equals(HD) || text.equals(LIST) || text.equals(FUNCTION) || text.equals(VARIABLE) || text.equals(STRING);
    }

}
