import java.io.File;

public class FIleInfordemo {
    public static void main(String[] args){
        File file = new File("sample.txt");
        if(file.exists()){
            System.out.println("File Name:"+file.getName());
            System.out.println("File Size:"+file.length());
            System.out.println("Path:"+file.getAbsolutePath());
        }else {
            System.out.print("File does not exists");
        }
    }
}

