import java.util.Scanner;

public class DividebyZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter neumerator:a");
        int a = sc.nextInt();
        System.out.println("Enter Demoniator:b");
        int b = sc.nextInt();

        try {
            int result = a/b;
            System.out.println("Result:"+result);
        }catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed.");
        }finally{
            System.out.print("Done");
        }
        sc.close();
    }
}