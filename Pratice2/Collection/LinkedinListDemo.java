
import java.util.*;


public class LinkedinListDemo {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        LinkedList<String> list = new LinkedList<>();
        System.out.println("Enter number of Cities");
        int n = sc.nextInt();
        sc.nextLine();
        for(int i =0 ;i<n;i++){
            System.out.println("Enter Name of Cities:"+i);
            String name = sc.nextLine();
            list.add(name);
        }

        System.out.println("\nCities:");
        for (String city : list) {
            System.out.println(city);
        }

    }
    
}
