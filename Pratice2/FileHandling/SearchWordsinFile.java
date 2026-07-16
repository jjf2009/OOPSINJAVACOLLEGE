
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class SearchWordsinFile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.err.println("Enter the word u want to search");
        String word = sc.nextLine();
        boolean found = false;

        try(BufferedReader reader = new BufferedReader(new FileReader("sample.txt"))){
            String line;
            int noline=0;
            while((line = reader.readLine())!=null){
                noline+=1;
                if(line.contains(word)){
                    System.err.println("Word Found at Line no"+noline);
                    found = true;
                }
            }
            if(!found){
                System.out.print("Word not Found");
            }

        }catch(IOException e){
            System.err.println(e);
        }
        
    }
}
