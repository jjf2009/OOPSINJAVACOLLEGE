import java.util.Scanner;
import java.util.Vector;

public class IntegerVector {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Vector<Integer> numbers = new Vector<>();

        System.out.print("Enter number of integers: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter integer " + (i + 1) + ": ");
            numbers.add(sc.nextInt());
        }

        System.out.println("\nIntegers in Vector:");
        for (int num : numbers) {
            System.out.println(num);
        }

        sc.close();
    }
}