import java.util.*;


public class Vectordemo {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Vector<Integer> v = new Vector<>();
        System.out.println("Enter number of Cities");
        int n = sc.nextInt();
        sc.nextLine();
        for(int i =0 ;i<n;i++){
            System.out.println("Enter Name of Cities:"+i);
            int num = sc.nextInt();
            v.add(num);
        }

        System.out.println("\nCities:");
        for (int city : v) {
            System.out.println(city);
        }

    }
    
}
