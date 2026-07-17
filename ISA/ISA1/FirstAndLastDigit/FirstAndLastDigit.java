import java.util.Scanner;

// First & Last Digit of a number
public class FirstAndLastDigit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        n = Math.abs(n); // handle negative
        int last = n % 10;

        int first = n;
        while (first >= 10) {
            first /= 10;
        }

        System.out.println("First digit: " + first);
        System.out.println("Last digit: " + last);
        sc.close();
    }
}
