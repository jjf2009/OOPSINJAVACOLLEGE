import java.util.Scanner;

// Special Number: sum of factorial of digits equals the number (e.g. 145)
public class SpecialNumber {

    static int factorial(int n) {
        int f = 1;
        for (int i = 1; i <= n; i++) {
            f *= i;
        }
        return f;
    }

    static boolean isSpecial(int num) {
        int temp = num;
        int sum = 0;
        while (temp > 0) {
            int digit = temp % 10;
            sum += factorial(digit);
            temp /= 10;
        }
        return sum == num;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        if (isSpecial(n)) {
            System.out.println(n + " is a Special Number");
        } else {
            System.out.println(n + " is NOT a Special Number");
        }
        sc.close();
    }
}
