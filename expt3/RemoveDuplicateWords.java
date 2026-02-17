import java.util.Scanner;

public class RemoveDuplicateWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine();

        String words[] = sentence.split(" ");
        String result = words[0];

        for (int i = 1; i < words.length; i++) {
            if (!words[i].equals(words[i - 1])) {
                result = result + " " + words[i];
            }
        }

        System.out.println("After removing duplicates: " + result);
        sc.close();
    }
}
