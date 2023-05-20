package SymbolsTable;

import java.util.HashMap;
import java.util.Vector;

public class SymbolTable {

    // --- Attributes -----------------------------------------------------------------------------

    /**
     * Vector of Symbols
     */
    private Vector<Symbol<Object>> table;

    /**
     * Parent Table
     */
    private SymbolTable parentTable;

    /**
     * Children Tables
     */
    private Vector<SymbolTable> childrenTable;

    /**
     * Functions
     */
    private HashMap<String, Integer> functions;

    // --- Constructors ---------------------------------------------------------------------------

    public SymbolTable() {
        this.table = new Vector<Symbol<Object>>();
        this.parentTable = null;
        this.childrenTable = new Vector<SymbolTable>();
        this.functions = new HashMap<String, Integer>();
    }

    public SymbolTable(HashMap<String, Integer> functions) {
        this.table = new Vector<Symbol<Object>>();
        this.parentTable = null;
        this.childrenTable = new Vector<SymbolTable>();
        this.functions = functions;
    }

    // --- Getter & Setter ------------------------------------------------------------------------

    public Vector<Symbol<Object>> getTable() {
        return this.table;
    }

    public void setTable(Vector<Symbol<Object>> table) {
        this.table = table;
    }

    public SymbolTable getParentTable() {
        return this.parentTable;
    }

    public Vector<SymbolTable> getChildrenTable() {
        return this.childrenTable;
    }

    public HashMap<String, Integer> getFunctions() {
        return this.functions;
    }

    // --- Methods --------------------------------------------------------------------------------

    /**
     * Ajoute un enfant à la table des symboles
     * @param child
     */
    public void addChild(SymbolTable child) {
        child.parentTable = this;
        this.childrenTable.add(child);
    }

    // --- Symbol Methods -------------------------------------------------------------------------

    /**
     * Ajoute la variable à la table des symboles
     * @param name : nom de la variable
     * @param line : ligne où elle a été déclarée
     * @return le symbole ajouté à la table des symboles
     */
    public Symbol<Object> putSymbol(String name, Object value) {
        Symbol<Object> symbol = new Symbol<Object>(name, value);
        if(!table.contains(symbol)) {
            table.add(symbol);
        }
        return symbol;
    }

    /**
     * Met à jour la valeur de la variable dans la table des symboles
     * @param name
     * @param value
     * @return
     */
    public Symbol<Object> setSymbolValue(String name, Object value) {
        Symbol<Object> symbol = new Symbol<Object>(name, value);
        if(table.contains(symbol)) {
            table.remove(symbol);
            table.add(symbol);
        }
        return symbol;
    }

    /**
     * Check si la variable existe dans la table des symboles
     * @param symbolTable
     * @param symbol
     * @return
     */
    public boolean containsSymbol(String symbolName){

        if(this.getTable().contains(new Symbol<Object>(symbolName, null)))
            return true;

        return false;
    }

    /**
     * Récupère la variable dans la table des symboles
     * @param table : table des symboles où le souhaite rechercher la variable
     * @param name : nom de la variable
     * @return le symbole correspondant à la variable
     */
    public Symbol<Object> getSymbol(String symbolName) {

        for(Symbol<Object> s : this.table) {
            if(s.getName().equals(symbolName)) {
                return s;
            }
        }
        
        return null;

    }

    // --- Function Methods -----------------------------------------------------------------------

    /**
     * Ajoute la fonction à la table des symboles
     * @param name
     * @param numerOfArguments
     */
    public void putFunction(String name, Integer numerOfArguments) {
        functions.put(name, numerOfArguments);
    }

    /**
     * Check si la fonction existe dans la table des symboles
     * @param symbolTable
     * @param functionName
     * @return
     */
    public boolean containsFunction(String functionName) {
        return this.functions.containsKey(functionName);
    }

    /**
     * Récupère le nombre d'arguments d'une fonction
     * @param symbolTable
     * @param functionName
     * @return
     */
    public Integer getNumberArguments(String functionName) {
        return this.functions.get(functionName);
    }

    /**
     * Récupère la table des fonctions
     * @return
     */
    public HashMap<String, Integer> getFunctionsTable() {
        return this.functions;
    }

    public boolean hasMainFunction() {
        return this.functions.containsKey("main");
    }

    // --- Display Methods ------------------------------------------------------------------------

    /**
     * Affiche la table des symboles
     */
    public void display(){

        System.out.println("Table des symboles :");
        
        display_();

    }

    private void display_(){

        for(Symbol<Object> s : table) {
            System.out.print(s.getName() + " = ");
            if(s.getValue() == null)
                System.out.println("null");
            else
                System.out.println(s.getValue());
        }

        int i = 0;
        for(SymbolTable st : childrenTable) {
            System.out.println("Table enfant " + i + " :");
            st.display_();
            i++;
        }

    }

    /**
     * Affiche la table des fonctions
     */
    public void displayFunctions(){

        System.out.println("Table des fonctions :");

        for(String s : functions.keySet()) {
            System.out.println(s + " : " + functions.get(s));
        }

    }

}