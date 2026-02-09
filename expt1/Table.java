import java.util.Scanner;

public class Table{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Your Number:");
        int n = sc.nextInt();
		 System.out.println("Enter Your Limit:");
        int l = sc.nextInt();
        int temp =0 ;
        for(int i =1;i<=l;i++){
			temp=n*i;
			System.out.println(n+" * "+i+"="+temp);

    }
}
}