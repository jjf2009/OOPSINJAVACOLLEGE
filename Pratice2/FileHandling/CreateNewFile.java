import java.io.File;
import java.io.IOException;

public class CreateNewFile {
    public static void main(String[] args){
    try {
          File file = new File("smaple.txt");
          if(file.createNewFile()){
            System.out.println("New File Created");
          }else{
            System.out.println("File ALready Exists");
          }
        } catch (IOException e) {
            System.err.println("IO Exception");
        }
          
    }  
}
