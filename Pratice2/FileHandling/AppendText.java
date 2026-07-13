import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AppendText {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text to append: ");
        String text = sc.nextLine();

        try (FileWriter writer = new FileWriter("sample.txt", true)) {
            writer.write(text + "\n");
            System.out.println("Text appended to sample.txt");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
