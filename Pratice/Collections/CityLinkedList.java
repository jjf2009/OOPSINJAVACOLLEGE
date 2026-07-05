import java.util.LinkedList;
import java.util.Scanner;

public class CityLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<String> cities = new LinkedList<>();

        System.out.print("Enter number of cities: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter city " + (i + 1) + ": ");
            cities.add(sc.nextLine());
        }

        System.out.println("\nCities:");
        for (String city : cities) {
            System.out.println(city);
        }

        sc.close();
    }
}