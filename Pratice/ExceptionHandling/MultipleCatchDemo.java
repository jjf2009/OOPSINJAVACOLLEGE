import java.util.Scanner;

public class MultipleCatchDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {5, 10, 15};

        System.out.print("Enter index: ");
        String indexInput = sc.nextLine();
        System.out.print("Enter divisor: ");
        String divisorInput = sc.nextLine();

        try {
            int index = Integer.parseInt(indexInput);
            int divisor = Integer.parseInt(divisorInput);
            System.out.println("Result: " + (arr[index] / divisor));
        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter valid integers.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Array index out of bounds.");
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero.");
        }

        sc.close();
    }
}