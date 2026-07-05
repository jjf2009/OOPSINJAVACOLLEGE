import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SearchWordInFile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter word to search: ");
        String word = sc.nextLine();
        boolean found = false;

        try (BufferedReader reader = new BufferedReader(new FileReader("sample.txt"))) {
            String line;
            int lineNo = 0;

            while ((line = reader.readLine()) != null) {
                lineNo++;
                if (line.contains(word)) {
                    System.out.println("Found at line " + lineNo + ": " + line);
                    found = true;
                }
            }

            if (!found) {
                System.out.println("Word not found.");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}