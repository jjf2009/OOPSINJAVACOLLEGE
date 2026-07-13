import java.util.*;

public class  ArrayLIstSearch {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> nums = new ArrayList<>();

        System.out.println("Enter number of elements :");
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            System.out.print("Enter your "+(i+1)+"element");
            int num = sc.nextInt();
            nums.add(num);
        }
        System.out.println("Enter element to be searched :");
        int ele = sc.nextInt();
        if(nums.contains(ele)){
            System.out.println("Element Found");
        }
    }
}

