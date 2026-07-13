import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



public class FileCopyDemo {
    public static void main(String[] args){
       try(BufferedReader file = new BufferedReader(new FileReader("sample.txt"));FileWriter writer = new FileWriter("copy.txt");){
           String line;
           while((line = file.readLine())!=null){
                  writer.write(line+"\n");
           }
       }catch(IOException e ){
          System.err.println(e);
       }
    }
}
