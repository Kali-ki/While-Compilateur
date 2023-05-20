package ThreeAddressToCpp;

import java.util.List;

import Tools.Tools;

public class ThreeAddressToCppGenerator {

 private List<String> code3a;
 private InstructionReader ir;

 public ThreeAddressToCppGenerator(List<String> code3a){
    this.code3a = code3a;
    this.ir = new InstructionReader();
 }

 public List<String> generateCPP(){
   for(String line : code3a){
      this.ir.read(line);
   }
   List<String> target =  ir.targetCode();
   target.add("int main(){\ncout<<main_()<<endl;\nreturn 0;}");
   return target;
 }

 /**
  * @creates program.cpp file
  @after
  g++ -o program program.cpp && ./program && rm program
  */
 public void writeCpp(String path){
   Tools.writeFile(path+"program.cpp",generateCPP());
 }
 public void writeCpp(){
  this.writeCpp(Tools.ROOT);
}

/**
 * Utilisé à des fins de développement  
 */
 public static void main(String[] args) {
   ThreeAddressToCppGenerator tacp = new ThreeAddressToCppGenerator(Tools.readFile("Java/program.asm"));
   tacp.writeCpp();
 }

    
}
