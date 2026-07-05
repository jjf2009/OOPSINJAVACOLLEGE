import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountFileLines {
    public static void main(String[] args) {
        int lineCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader("sample.txt"))) {
            while (reader.readLine() != null) {
                lineCount++;
            }
            System.out.println("Total lines: " + lineCount);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}