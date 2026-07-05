import java.util.Scanner;

public class NumberFormatDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        String input = sc.nextLine();

        try {
            int number = Integer.parseInt(input);
            System.out.println("Valid number entered: " + number);
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format.");
        }

        sc.close();
    }
}