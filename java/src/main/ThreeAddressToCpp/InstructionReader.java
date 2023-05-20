package ThreeAddressToCpp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.regex.Pattern;

public class InstructionReader {

    
    private List<Instruction> instructions; // instructions possibles 
    private List<String> code_cible; 
    private int index_buffer; //indice dans code_cible de la déclaration de la méthode courante
    private Map<String,String> local_variables; // variables locales à la méthode courante
    private Map<String,String> known_methods; // noms des méthodes analysés jusqu'ici, ainsi que leur type associé
    private Stack<String> stack_params; // gestion de la pile des appels de paramètres
    private Map<String,String> param_variables; // paramètres et types associés de la méthode courante


    public InstructionReader(){
        index_buffer=-1;
        local_variables = new LinkedHashMap<>();
        known_methods = new LinkedHashMap<>();
        param_variables = new LinkedHashMap<>();
        code_cible = new ArrayList<>();
        code_cible.add("#include <string>\n#include <iostream>\nusing namespace std;\n");
        instructions = new ArrayList<>();
        instructions.add(new AssignationCopy());
        instructions.add(new AssignationUnop());
        instructions.add(new AssignationBiop());
        instructions.add(new InconditionalJump());
        instructions.add(new ConditionalJump());
        instructions.add(new FunctionBegin());
        instructions.add(new Param());
        instructions.add(new FunctionEnd());
        instructions.add(new ReturnResult());
        instructions.add(new Call());
        instructions.add(new Label());
    }


    public void read(String c3a){
        for(Instruction i : instructions){
            if(i.isReadable(c3a))i.read(code_cible);
        }
    }

    public List<String> targetCode(){
        return this.code_cible;
    }

    private String getType(String variable){
        String type = "int";
        Map<String,String> map = null;
        if(local_variables.containsKey(variable)){type = local_variables.get(variable);map=local_variables;}
        else if(param_variables.containsKey(variable)){type = param_variables.get(variable);map=param_variables;}
        else if(known_methods.containsKey(variable)){type = known_methods.get(variable);map=known_methods;}
        if(map==null || type.equals("int") || type.equalsIgnoreCase("string"))return type;
        else return getType(type);
    }

    private void setType(String variable, String type){
       if(local_variables.containsKey(variable)) local_variables.put(variable, type);
       else if(param_variables.containsKey(variable)) param_variables.put(variable, type);
       else if(known_methods.containsKey(variable)) known_methods.put(variable, type);
    }

    private String winningType(String v1, String v2){
       String t1 = getType(v1);
       String t2 = getType(v2);
       if(t1.equals("string") || t2.equals("string"))return "string";
       else return "int";
    }

    private boolean isNumber(String s){
        String regex = "[0-9]+[\\.]?[0-9]*";
        return Pattern.matches(regex, s);
    }
 
    
    public abstract class Instruction {
        protected String [] words;

        protected List<String> getList(){
            return Arrays.asList(words);
        }

        protected boolean containsWord(String word){
            return getList().contains(word);
        }
        
        /**
         * An instruction must be first checked with isReadable
          then it can be convertedToCpp, by adding it to a codeCpp list if it makes sense
         */
        public Instruction(){}
        
        protected abstract boolean isReadable();
        
        protected abstract String read();

        public void setC3A(String c3a){
           this.words =  c3a.split(" ");
        }
     
        public void read(List<String>codeLangageCible){
           assert(this.isReadable()):"The instruction must be readable !";
           String converted = this.read();
           if(converted.length()>0)codeLangageCible.add(converted);
        }
        
        public boolean isReadable(String c3a){
            setC3A(c3a);
           return isReadable();
        }
        
      }

      public abstract class Assignation extends Instruction {

        protected boolean isReadable() {
            return words.length>2 && words[1].equalsIgnoreCase("=");
        }

        protected String assignationValue(String assignation){
            local_variables.put(words[0],getType(assignation));
            Set<String> known = (new HashSet<>(local_variables.keySet()));
            known.addAll(param_variables.keySet());
            if(!known.contains(assignation) && !isNumber(assignation)){
                assignation= '"'+assignation+'"';
                setType(words[0], "string");
            }
            if(param_variables.containsKey(assignation)){
                setType(assignation, words[0]); // pour l'instant on stocke le nom de la variable
            }
            return assignation;
        }

      }

      public class AssignationCopy extends Assignation {

        protected String read() {
            return words[0]+" = "+assignationValue(words[2])+";";
        }

        protected boolean isReadable() {
            return super.isReadable() && words.length==3;
        }

      }

      public class AssignationUnop extends Assignation {
  
        protected String read() {
            return words[0]+" = "+ words[2]+  assignationValue(words[3])+";";
        }
        
        protected boolean isReadable() {
            return super.isReadable() && words.length == 4 && isUnopSymbol(words[2]);
        }
        
        String [] unopSymbols = {"-","!","~"};
        private boolean isUnopSymbol(String s){
            for(String symbol : unopSymbols){
                if(symbol.equalsIgnoreCase(s))return true;
            }
            return false;
        }
        
      }

      public class AssignationBiop extends Assignation {

        protected String read() {
            local_variables.put(words[0],winningType(words[2],words[4]));
            if(words[3].equals("+") && getType(words[0]).equals("string")){ // On met tout le monde au type string
                setType(words[2], "string");
                setType(words[4], "string");

            }
            return words[0]+" = "+ words[2]+" "+words[3]+" "+words[4]+";";
        }

        protected boolean isReadable() {
            return super.isReadable() && words.length == 5 && isBiopSymbol(words[3]);
        }

        String [] biopSymbols = {"*","+","-","/","&","|","<",">"};
        private boolean isBiopSymbol(String s){
            for(String symbol : biopSymbols){
                if(symbol.equalsIgnoreCase(s))return true;
            }
            return false;
        }

      }

      public abstract class Jump extends Instruction {

        protected boolean isReadable() {
            return words.length > 1 && containsWord("goto");
        }
        
      }

      public class InconditionalJump extends Jump {

        protected boolean isReadable(){
            return super.isReadable() && words.length==2;
        }

        protected String read() {
            return words[0]+" "+words[1]+";";
        }
        
      }

      public class ConditionalJump extends Jump {

        public boolean isReadable(){
           return super.isReadable() && words[0].contains("if");
        }

        /**
         * @warn there is a big diversity of if
         */
        protected String read() {
            String if_cond = words[0];
            String conversion = "";
            if(if_cond.equalsIgnoreCase("ifz"))conversion+="if("+words[1]+"==0)";
            if(if_cond.equalsIgnoreCase("ifnz"))conversion+="if("+words[1]+"!=0)";
            return conversion+"{ goto "+words[3]+";}";
            
        }

      }

      public abstract class Function extends Instruction {

        protected boolean isReadable() {
            return words.length>0;
        }
        
      }
      
      public class FunctionBegin extends Function {

        protected boolean isReadable() {
            return super.isReadable() && 
            words.length==3 && 
            words[0].equalsIgnoreCase("func") &&
            words[1].equalsIgnoreCase("begin");
        }

        protected String read() {
            local_variables = new LinkedHashMap<>();
            stack_params = new Stack<>();
            param_variables = new LinkedHashMap<>();
            index_buffer = code_cible.size();
            known_methods.put(words[2]+"_", getType(words[2]));
            return words[2]+"_";
        }
        
      }

      public class Param extends Function {

        protected boolean isReadable() {
            return words.length==2 &&
            words[0].equalsIgnoreCase("param");
        }
        
        protected String read() {
            stack_params.add(words[1]);
            if(index_buffer==code_cible.size()-1) param_variables.put(words[1], getType(words[1]));
            return "";
        }  
      }

      public class FunctionEnd extends Function {
        
        protected boolean isReadable() {
            return super.isReadable() && 
            words.length==2 &&
            words[0].equalsIgnoreCase("func") &&
            words[1].equalsIgnoreCase("end");
        }

        protected String read() {
            String decl = code_cible.get(index_buffer);
            String begin = declarationArguments();
            setType(decl, getType(decl));
            decl = getType(decl) +" "+begin;
            if(!decl.contains("("))decl+="(";
            decl+="){";
            for(String variable : local_variables.keySet()){
                decl+="\n"+getType(variable)+" "+variable+";";
            }
            code_cible.set(index_buffer, decl);
            return "}\n";
        }

        private String declarationArguments(){
            String decl = code_cible.get(index_buffer);
            for(String param :param_variables.keySet()){
                boolean first_param = !decl.contains("(");
                decl+=first_param?"(":",";
                String type = getType(param_variables.get(param));
                setType(param, type);
                decl += type+" "+param;
            }
            return decl;
        }
      }

      public class ReturnResult extends Function {

        protected boolean isReadable() {
            return super.isReadable() &&
            words.length==2 && 
            words[0].equalsIgnoreCase("return");
        }

        protected String read() {
            setType(code_cible.get(index_buffer), (words[1])); // Indication du type de la variable pour calcul de type différé
            return "return "+words[1]+";";
        }
        
      }

      public class Call extends Function {

        protected boolean isReadable() {
            return super.isReadable() &&
            words.length == 5 &&
            words[1].equalsIgnoreCase("=") &&
            words[2].equalsIgnoreCase("call")
            ;
        }

        protected String read() {
            local_variables.put(words[0],getType(words[0]));
            String params = "";
            for(int i = 0;i<Integer.parseInt(words[4]);i++){
               params+=(params.length()>0?",":"")+ (stack_params.pop());
            }
            return words[0]+" = "+words[3] +"_"
            +"("+params+");" 
            ;
        }
        
      }

      public class Label extends Instruction {

        protected boolean isReadable() {
            return words.length==1 && 
            words[0].length()>1 &&
            words[0].charAt(words[0].length()-1)==':';
        }

        protected String read() {
            return words[0];
        }
        
      }

    }
