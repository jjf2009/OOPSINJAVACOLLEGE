import java.util.Scanner;

public class DisplayDulicates {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements of the array: ");
        int n = sc.nextInt();
        sc.nextLine(); 

        String[] arr = new String[n];

        System.out.println("Enter the strings:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLine();
        }
		     for (int i = 0; i < n; i++) {
            arr[i] = arr[i].toLowerCase();
        }

        System.out.println("Duplicate elements:");
        boolean found = false;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i].equals(arr[j])) {
                    System.out.println(arr[i]);
                    found = true;
                    break;
                }
            }
        }

   if (!found) {
            System.out.println("No duplicates found.");
        }
        sc.close();
    }
}
