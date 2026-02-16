import java.util.Scanner;
import java.util.Arrays;

public class MedianofArray {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements of the array: ");
        int num = sc.nextInt();

        System.out.println("Enter elements of the array:");
        int arr[] = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        if (num % 2 == 0) {
            int ind1 = (num / 2) - 1;
            int ind2 = (num / 2);
            System.out.println("Median of Array="+(double) (arr[ind1] + arr[ind2]) / 2);
        } else {
            System.out.println("Median of Array="+arr[num / 2]);
        }

        sc.close();
    }
}
