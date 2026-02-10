import java.util.Scanner;

public class MedianofArray {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of elements of the array:");
		int num = sc.nextInt();
		System.out.println("Enter elements of the array:");
		int arr[] = new int[num];
		for(int i =0;i<num;i++){
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
	      
}}