import java.util.Scanner;

public class FirstAndLast {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Your Number:");
        int num = sc.nextInt();	
		int lastdegit = num%10;
		int firstdegit=0;
		while(num>0){
		 firstdegit = num%10;
		num=num/10;
		}
       System.out.println("First Degit: "+firstdegit+" Last Degit: "+lastdegit);
    }
}
