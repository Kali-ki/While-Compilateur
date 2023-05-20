package ThreeAddressCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTree;

/**
 * Classe pour générer le code 3 adresses en parcourant l'AST
 */
public class ThreeAddressCodeGenerator {
  // Code 3 adresses qui sera généré
  private List<String> code3adresses = new ArrayList<>();

  // Hash map permettant de garder en mémoire toutes les variables lié à leur
  // arbre binaire
  private HashMap<String, CommonTree> varsMemory = new HashMap<>();

  // Les numeros des registres et des labels
  private int numberRegister = 0;
  private int numberLabel = 0;

  // Les différents types de noeuds
  private final String PROGDEF = "PROGDEF";
  private final String FONCTION_DEF = "FONCTION_DEF";
  private final String BODY = "BODY";
  private final String INPUTSUB = "INPUTSUB";
  private final String OUTPUT = "OUTPUT";
  private final String COMMAND = "COMMAND";
  private final String VARIABLE_DEF = "VARIABLE_DEF";
  private final String IF = "IF";
  private final String WHILE = "WHILE";
  private final String FOR = "FOR";
  private final String FOREACH = "FOREACH";
  private final String VARIABLE = "VARIABLE";
  private final String FUNCTION = "FUNCTION";
  private final String STRING = "STRING";
  private final String CONS = "CONS";
  private final String LIST = "LIST";
  private final String HD = "HD";
  private final String TL = "TL";

  public ThreeAddressCodeGenerator() {
  }

  /**
   * Création d'un nouveau nom de registre unique
   * 
   * @return le nom du registre
   */
  private String getRegister() {
    numberRegister++;
    return "R" + numberRegister;
  }

  /**
   * Création d'un nouveau nom de label unique
   * 
   * @return le nom du label
   */
  private String getLabel() {
    numberLabel++;
    return "L" + numberLabel;
  }

  /**
   * Génération du code 3 adresses
   * 
   * @param ast : l'arbre de syntaxe abstraite
   * @return le code 3 adressses sous forme de liste (chaque String correspond à 1
   *         ligne du code 3 adresses)
   */
  public List<String> generate(CommonTree ast) {
    List<String> code3a = new ArrayList<>();

    // Parcourt de l'AST en vérifiant chaque noeud
    switch (ast.getText()) {
      case PROGDEF:
        // Traitement des fonctions
        CommonTree functionNode;
        for (int i = 0; i < ast.getChildCount(); i++) {
          functionNode = (CommonTree) ast.getChild(i);
          code3a.addAll(generate(functionNode));
        }
        break;
      case FONCTION_DEF:
        // Réinitialisation de la mémoire
        varsMemory = new HashMap<>();

        // Traitement de la définition de fonction
        CommonTree symbolNode = (CommonTree) ast.getChild(0);
        CommonTree definitionNode = (CommonTree) ast.getChild(1);

        String symbolName = symbolNode.getText();
        code3a.add("func begin " + symbolName);

        code3a.addAll(generate(definitionNode));
        break;
      case BODY:
        // Traitement du corps de la fonction
        CommonTree inputNode;
        CommonTree commandsNode;
        CommonTree outputNode;
        if (ast.getChildren().size() > 2) {
          inputNode = (CommonTree) ast.getChild(0);
          commandsNode = (CommonTree) ast.getChild(1);
          outputNode = (CommonTree) ast.getChild(2);

          code3a.addAll(generate(inputNode));
          code3a.addAll(generate(commandsNode));
          code3a.addAll(generate(outputNode));
        } else {
          commandsNode = (CommonTree) ast.getChild(0);
          outputNode = (CommonTree) ast.getChild(1);

          code3a.addAll(generate(commandsNode));
          code3a.addAll(generate(outputNode));
        }
        break;
      case INPUTSUB:
        // Traitement des entrées (paramètres) de la fonction
        CommonTree variableInputNode;
        for (int i = 0; i < ast.getChildCount(); i++) {
          variableInputNode = (CommonTree) ast.getChild(i);
          code3a.add("param " + variableInputNode.getText());
        }
        break;
      case OUTPUT:
        // Traitement des sorties de la fonction
        CommonTree variableOutputNode = (CommonTree) ast.getChild(0);

        String variableName = variableOutputNode.getText();
        code3a.add("return " + variableName);

        CommonTree outputVarNode;
        if (ast.getChildCount() > 1) {
          outputVarNode = (CommonTree) ast.getChild(1);
          code3a.addAll(generate(outputVarNode));
        }

        code3a.add("Return");
        code3a.add("func end");
        break;
      case COMMAND:
        // Traitement des commandes
        CommonTree commandNode = (CommonTree) ast.getChild(0);
        code3a.addAll(generate(commandNode));

        CommonTree secondCommandNode;
        if (ast.getChildCount() > 1) {
          secondCommandNode = (CommonTree) ast.getChild(1);
          code3a.addAll(generate(secondCommandNode));
        }
        break;
      case IF:
        // Traitement des instructions IF
        CommonTree conditionNode = (CommonTree) ast.getChild(0);
        CommonTree thenCommandsNode = (CommonTree) ast.getChild(1);
        String end_if_label = getLabel();
        String else_label = getLabel();

        // Condition
        String register1 = getRegister();
        List<String> conditionNode3Adresse = this.getExpression(conditionNode, register1);
        code3a.addAll(conditionNode3Adresse);

        if (ast.getChildCount() > 2) {
          code3a.add("ifz " + register1 + " goto " + else_label);
        } else {
          code3a.add("ifz " + register1 + " goto " + end_if_label);
        }

        // Then
        code3a.addAll(generate(thenCommandsNode));
        code3a.add("goto " + end_if_label);

        // Else (optional)
        CommonTree elseCommandsNode;
        if (ast.getChildCount() > 2) {
          elseCommandsNode = (CommonTree) ast.getChild(2);
          code3a.add(else_label + ":");
          code3a.addAll(generate(elseCommandsNode));
        }

        code3a.add(end_if_label + ":");
        break;
      case WHILE:
        // Traitement des instructions "while"
        CommonTree whileExpressionNode = (CommonTree) ast.getChild(0);
        CommonTree doCommandsNode = (CommonTree) ast.getChild(1);
        String startWhileLabel = getLabel();
        String endWhileLabel = getLabel();

        // Condition
        String r1 = getRegister();
        List<String> whileExpressionNode3Adresse = this.getExpression(whileExpressionNode, r1);
        code3a.add(startWhileLabel + ":");
        code3a.addAll(whileExpressionNode3Adresse);
        code3a.add("ifz " + r1 + " goto " + endWhileLabel);

        // Do commands
        code3a.addAll(generate(doCommandsNode));
        code3a.add("goto " + startWhileLabel);

        code3a.add(endWhileLabel + ":");
        break;
      case FOR:
        // Traitement des instructions "for"
        CommonTree forExpressionNode = (CommonTree) ast.getChild(0);
        CommonTree forDoCommandsNode = (CommonTree) ast.getChild(1);
        String startForLabel = getLabel();
        String endForLabel = getLabel();

        // Condition
        String r_for_1 = getRegister();
        List<String> forExpressionNode3Adresse = this.getExpression(forExpressionNode, r_for_1);
        code3a.addAll(forExpressionNode3Adresse);
        code3a.add(startForLabel + ":");
        code3a.add("ifz " + r_for_1 + " goto " + endForLabel);

        // Do commands
        code3a.addAll(generate(forDoCommandsNode));
        code3a.add(r_for_1 + " = " + r_for_1 + " - " + 1);
        code3a.add("goto " + startForLabel);

        code3a.add(endForLabel + ":");
        break;
      case FOREACH:
        // Traitement des instructions "foreach"
        // CommonTree var = (CommonTree) ast.getChild(0);
        CommonTree foreachExprsNode = (CommonTree) ast.getChild(1);
        CommonTree foreachDoCommandsNode = (CommonTree) ast.getChild(2);

        String startForeachLabel = getLabel();
        String endForeachLabel = getLabel();

        // Condition
        String r_foreach_1 = getRegister();
        List<String> foreachExpressionNode3Adresse = this.getExpression(foreachExprsNode, r_foreach_1);
        code3a.addAll(foreachExpressionNode3Adresse);
        code3a.add(startForeachLabel + ":");
        code3a.add("ifz " + r_foreach_1 + " goto " + endForeachLabel);

        // Do commands
        code3a.addAll(generate(foreachDoCommandsNode));
        code3a.add(r_foreach_1 + " = " + r_foreach_1 + " - " + 1);
        code3a.add("goto " + startForeachLabel);

        code3a.add(endForeachLabel + ":");
        break;
      case VARIABLE_DEF:
        // Traitement des affectations de variables
        CommonTree varsNode = (CommonTree) ast.getChild(0);
        CommonTree exprsNode = (CommonTree) ast.getChild(1);

        for (int i = 0; i < varsNode.getChildCount(); i++) {
          String variable = varsNode.getChild(i).getText();

          String registre = getRegister();
          if (i < exprsNode.getChildCount()) {
            // Stockage de la variable en mémoire
            CommonTree value = this.putInMemory(variable, (CommonTree) exprsNode.getChild(i));

            code3a.addAll(this.getExpression(value, registre));
          } else {
            // Stockage de la variable en mémoire
            CommonToken nilToken = new CommonToken(52, "nil");
            CommonTree nilTree = new CommonTree(new CommonToken(nilToken));
            varsMemory.put(variable, nilTree);

            code3a.add(registre + " = 0");
          }
          code3a.add(variable + " = " + registre);
        }
        break;
      default:
        // Traitement des autres noeuds
        CommonTree childNode;
        for (int i = 0; i < ast.getChildCount(); i++) {
          childNode = (CommonTree) ast.getChild(i);
          code3a.addAll(generate(childNode));
        }
        break;
    }
    this.code3adresses = code3a;
    return code3a;
  }

  /**
   * Récupération du code 3 adresses pour une expression à évaluer
   * 
   * @param ast      : l'arbre de syntaxe abstraite
   * @param registre : nom du registre où doit être assigné sa valeur
   * @return code 3 adrresses de l'expression
   */
  private List<String> getExpression(CommonTree ast, String registre) {
    List<String> expression3Adresses = new ArrayList<String>();
    switch (ast.getText()) {
      case FUNCTION:
        // Traitement des appels des fonctions
        CommonTree fonctionNode = (CommonTree) ast.getChild(0);
        CommonTree expNode;

        int nbParams = 0;
        for (int i = 1; i < ast.getChildCount(); i++) {
          expNode = (CommonTree) ast.getChild(i);
          nbParams++;
          expression3Adresses.add("param " + expNode.getChild(0).getText());
        }
        expression3Adresses.add(registre + " = call " + fonctionNode.getText() + " " + nbParams);
        break;
      case "nil":
        expression3Adresses.add(registre + " = " + "0");
        break;
      case VARIABLE:
        // Traitement des variables
        String varName = ast.getChild(0).getText();
        if (varName == null) {
          expression3Adresses.add(registre + " = " + "0");
        } else {
          expression3Adresses.add(registre + " = " + varName);
        }
        break;
      case STRING:
        expression3Adresses.add(registre + " = " + ast.getChild(0).getText());
        break;
      case CONS:
        // Traitement des constructions des arbes binaires
        if (hasStringChild(ast)) {
          List<CommonTree> commonTrees = new ArrayList<CommonTree>();
          for (int i = 0; i < ast.getChildCount(); i++) {
            commonTrees.add((CommonTree) ast.getChild(i));
          }

          if (commonTrees.size() == 2 && commonTrees.get(1).getText().equals("nil")) {
            expression3Adresses.addAll(this.getExpression(commonTrees.get(0), registre));
          } else if (commonTrees.size() == 1) {
            expression3Adresses.addAll(this.getExpression(commonTrees.get(0), registre));
          } else if (commonTrees.size() > 1) {
            expression3Adresses.addAll(this.getCodeCons(commonTrees, registre, true));
          }
        } else {
          if (ast.getChildCount() == 0) {
            expression3Adresses.add(registre + " = " + "0");
          } else if (ast.getChildCount() == 1) {
            expression3Adresses
                .addAll(this.getExpression((CommonTree) ast.getChild(0), registre));
          } else {
            List<CommonTree> commonTrees = new ArrayList<CommonTree>();
            for (int i = 1; i < ast.getChildCount(); i++) {
              commonTrees.add((CommonTree) ast.getChild(i));
            }
            expression3Adresses.addAll(this.getCodeCons(commonTrees, registre, false));
          }
        }
        break;
      case LIST:
        // Traitement des listes
        for (int i = 0; i < ast.getChildCount(); i++) {
          String registreList = getRegister();
          expression3Adresses.addAll(this.getExpression((CommonTree) ast.getChild(i), registreList));
          expression3Adresses.add(registre + "[" + i + "]" + " = " + registreList);
        }
        break;
      case HD:
        // Traitement des têtes d'arbres
        CommonTree hdTree = (CommonTree) ast.getChild(0);
        switch (hdTree.getText()) {
          case CONS:
            expression3Adresses
                .addAll(this.getExpression((CommonTree) hdTree.getChild(0), registre));
            break;
          default:
            expression3Adresses.add(registre + " = " + "0");
            break;
        }
        break;
      case TL:
        // Traitement des queues d'arbres
        CommonTree tlTree = (CommonTree) ast.getChild(0);
        switch (tlTree.getText()) {
          case CONS:
            expression3Adresses
                .addAll(this.getExpression((CommonTree) tlTree.getChild(1), registre));
            break;
          case VARIABLE:
            String varTLName = tlTree.getChild(0).getText();
            expression3Adresses.add(registre + " = " + varTLName + "- 1");
            break;
          default:
            expression3Adresses.add(registre + " = " + "0");
            break;
        }
        break;
      default:
        // Traitements des arbes à évaluer
        expression3Adresses.add(registre + " =  0");
        break;
    }
    return expression3Adresses;
  }

  /**
   * Récupération du code 3 adresses d'un arbre binaire selon son type (String ou
   * int)
   * 
   * @param ctList         : liste de tous les noeuds enfants de l'arbre
   * @param registre       : nom du registe où doit être enregistré l'arbre
   * @param hasStringChild : vrai si l'arbre est un string sinon faux
   * @return le code 3 adresses de l'arbre binaire
   */
  private List<String> getCodeCons(List<CommonTree> ctList, String registre, boolean hasStringChild) {
    List<String> expression3Adresses = new ArrayList<String>();

    if (hasStringChild) {
      String registreCons1 = getRegister();
      expression3Adresses.addAll(this.getExpression(ctList.get(0), registreCons1));
      ctList.remove(ctList.get(0));

      String registreCons2 = getRegister();
      if (ctList.size() < 2) {
        expression3Adresses.addAll(this.getExpression(ctList.get(0), registreCons2));
      } else {
        expression3Adresses.addAll(this.getCodeCons(ctList, registreCons2, hasStringChild));
      }

      expression3Adresses.add(registre + " = " + registreCons1 + " + " + registreCons2);
    } else {
      String registreCons = getRegister();
      if (ctList.size() < 2) {
        expression3Adresses.addAll(this.getExpression(ctList.get(0), registreCons));
      } else {
        ctList.remove(ctList.get(0));
        expression3Adresses.addAll(this.getCodeCons(ctList, registreCons, hasStringChild));
      }

      expression3Adresses.add(registre + " = 1 + " + registreCons);

    }
    return expression3Adresses;
  }

  /**
   * Vérification si l'arbre est une chaine de caractères
   * 
   * @param ast : l'arbre de syntaxe abstraite
   * @return vrai si l'arbre est une chaine de caractères sinon faux
   */
  private boolean hasStringChild(CommonTree ast) {
    for (int i = 0; i < ast.getChildCount(); i++) {
      if (ast.getChild(i).getText().equals(STRING)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Stockage des variable dans la mémoire
   * 
   * @param variable : nom de la variable
   * @param ast      : arbre binaire
   * @return l'arbre binaire (bien construit)
   */
  private CommonTree putInMemory(String variable, CommonTree ast) {
    CommonTree value = this.getCommonTree(ast);
    varsMemory.put(variable, value);
    return value;
  }

  /**
   * Réorganisation de l'arbre binaire afin d'être sûr d'avoir maximum 2 enfants
   * pour chaque noeud
   * 
   * @param ast : arbre binaire que l'on souhaite réorganisé
   * @return l'arbre binaire réorganisé (valeur de celuii-ci inchangée)
   */
  private CommonTree getCommonTree(CommonTree ast) {
    CommonTree child;
    switch (ast.getText()) {
      case CONS:
        Token consToken = ast.getToken();
        child = (CommonTree) ast.getChild(0);
        if (child.getText().equals(VARIABLE)) {
          ast.setChild(0, varsMemory.get(child.getChild(0).getText()));
        } else {
          this.getCommonTree(child);
        }

        if (ast.getChildCount() > 2) {
          CommonTree newTree = new CommonTree(new CommonToken(consToken));
          for (int i = 1; i < ast.getChildCount(); i++) {
            newTree.addChild(ast.getChild(i));
          }
          int nbChild = ast.getChildCount();
          for (int i = 1; i < nbChild; i++) {
            ast.deleteChild(1);
          }
          CommonTree rightChild = this.getCommonTree(newTree);
          ast.addChild(rightChild);

        } else if (ast.getChildCount() == 2) {
          child = (CommonTree) ast.getChild(1);
          if (child.getText().equals(VARIABLE)) {
            String varName = child.getChild(0).getText();
            if (!(varsMemory.get(varName).getText().equals(VARIABLE))) {
              ast.setChild(1, varsMemory.get(varName));
            }
          } else {
            this.getCommonTree(child);
          }
        }
        break;
      case HD:
        child = (CommonTree) ast.getChild(0);
        if (child.getText().equals(CONS)) {
          return (CommonTree) child.getChild(0);
        } else if (child.getText().equals(VARIABLE)) {
          return (CommonTree) varsMemory.get(child.getChild(0).getText()).getChild(0);
        } else {
          return new CommonTree();
        }
      case TL:
        child = (CommonTree) ast.getChild(0);
        if (child.getText().equals(CONS)) {
          if (child.getChildCount() > 1) {
            return (CommonTree) child.getChild(1);
          } else {
            return new CommonTree();
          }
        } else if (child.getText().equals(VARIABLE)) {
          CommonTree variableTree = varsMemory.get(child.getChild(0).getText());
          if (variableTree.getChildCount() > 1) {
            return (CommonTree) variableTree.getChild(1);
          } else {
            return new CommonTree();
          }

        } else {
          return new CommonTree();
        }
    }
    return ast;
  }

  /**
   * Affichage du code 3 adresses
   */
  public void display() {
    System.out.println("\n\nCode 3 adresses : ");
    for (String instruction : this.code3adresses) {
      System.out.println(instruction);
    }
  }
}