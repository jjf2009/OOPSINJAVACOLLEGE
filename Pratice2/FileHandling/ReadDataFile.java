
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class ReadDataFile {
    public static void main(String[] args) {
        try(BufferedReader file = new BufferedReader(new FileReader("student.txt"))){
            String line;
            while((line = file.readLine())!=null){
                      System.out.println(line);
            }
        } catch (IOException e) {
            System.out.print(e);
        }
    }
    
}
