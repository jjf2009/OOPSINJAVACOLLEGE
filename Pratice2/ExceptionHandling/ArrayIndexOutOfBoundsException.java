
import java.util.Scanner;


public class ArrayIndexOutOfBoundsException {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] numbers = {1,2,3,4,5};
        System.out.println("Enter index to be accesed");
        int index = sc.nextInt();
        try {
            System.out.println("Value:"+numbers[index]);
        } catch (Exception e) {
            System.out.println("Out of bounds");
        }
    }
}
