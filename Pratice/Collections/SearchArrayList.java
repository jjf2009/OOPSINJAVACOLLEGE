import java.util.ArrayList;
import java.util.Scanner;

public class SearchArrayList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> fruits = new ArrayList<>();

        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Mango");
        fruits.add("Orange");

        System.out.println("List: " + fruits);
        System.out.print("Enter element to search: ");
        String search = sc.nextLine();

        if (fruits.contains(search)) {
            System.out.println(search + " found at index " + fruits.indexOf(search));
        } else {
            System.out.println(search + " not found.");
        }

        sc.close();
    }
}