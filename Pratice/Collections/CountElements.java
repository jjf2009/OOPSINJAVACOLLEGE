import java.util.ArrayList;
import java.util.Scanner;

public class CountElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter value " + (i + 1) + ": ");
            list.add(sc.nextInt());
        }

        System.out.println("Total elements in collection: " + list.size());

        sc.close();
    }
}