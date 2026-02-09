import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Your Number:");
        
        int num = sc.nextInt();
        int temp = num;
        int sum = 0;

        while (num > 0) {
            int x = num % 10;
            sum = sum * 10 + x;
            num = num / 10;
        }

        if (sum == temp) {
            System.out.println("Number is a Palindrome");
        } else {
            System.out.println("Number is not a Palindrome");
        }
    }
}
