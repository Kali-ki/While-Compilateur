package Tools;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Tools {

   public static String PATH_BASE = "java/src/";
   public static String ROOT ="java/";

    public  static  List<String> readFile(String location) {
        List<String> lines = new LinkedList<>();
        try {
           File f = new File(location);
           Scanner reader = new Scanner(f);
           while(reader.hasNextLine()){
              String data = reader.nextLine();
              lines.add(data);
           }
           reader.close();
        } catch (Exception e) {
           System.err.println(e);
        }
        return lines;
      }
     
      public static void writeFile(String location,List<String> content){
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
           new FileOutputStream(location), "utf-8"))){
              for(String line : content){
                 writer.write(line+"\n");
              }
        } catch (Exception e) {
           System.err.println("The file could not be written");
        }
      }


    
}
