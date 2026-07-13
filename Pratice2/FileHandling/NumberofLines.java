import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class NumberofLines {
        public static void main(String[] args) {
        try(BufferedReader file = new BufferedReader(new FileReader("student.txt"))){
            String line;
            int linecount=0;
            while((line = file.readLine())!=null){
                      linecount++;
            }
         System.out.println("Number of Lines:"+linecount);
        } catch (IOException e) {
            System.out.print(e);
        }
    }
}
