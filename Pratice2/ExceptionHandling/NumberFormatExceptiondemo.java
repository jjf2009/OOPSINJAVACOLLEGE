import java.util.Scanner;

public class NumberFormatExceptiondemo {
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        String input = sc.nextLine();
    try 
    {
         int num = Integer.parseInt(input);
    } catch (NumberFormatException e) {
        System.err.println("Input is not a number");
    }
}
}
