import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListAddRemove {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();

        System.out.print("Enter element to add: ");
        list.add(sc.nextLine());
        System.out.print("Enter another element to add: ");
        list.add(sc.nextLine());

        System.out.println("List after adding: " + list);

        System.out.print("Enter element to remove: ");
        String removeItem = sc.nextLine();
        list.remove(removeItem);

        System.out.println("List after removing: " + list);

        sc.close();
    }
}