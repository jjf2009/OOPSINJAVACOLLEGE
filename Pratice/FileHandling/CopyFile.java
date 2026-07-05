import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyFile {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("sample.txt"));
             FileWriter writer = new FileWriter("copy.txt")) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line + "\n");
            }
            System.out.println("File copied to copy.txt");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}