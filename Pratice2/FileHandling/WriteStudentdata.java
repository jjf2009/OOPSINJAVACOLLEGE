import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WriteStudentdata {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name");
        String name = sc.nextLine();
        try(FileWriter file = new FileWriter("student.txt")){
            file.write("Name:"+name+"\n");
        } catch (IOException e) {
             System.out.println(e);
        }
    }
}
