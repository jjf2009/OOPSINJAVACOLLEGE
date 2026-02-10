import java.util.Scanner;

public class BinToOct {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        System.out.println("Enter Your Binary Number:");
		     int bin = sc.nextInt();
		System.out.println("Your Binary Number:"+bin);
        int dec = 0;
		int base =1;
        while (bin > 0) {
            int x = bin % 10;
            dec += x * base;
			base*=2;
            bin = bin / 10;
        }
            System.out.println("Your Decimal Number:"+dec); 
		    int oct=0;
			 while (dec > 0) {
            int x = dec % 8;
           oct = oct *10+x;
            dec=dec/8;
        }
		
		 System.out.print("Your Octet Number:"); 
		 int x=0;
		 	while (oct > 0) {
            x = oct % 10;
			System.out.print(x); 
            oct=oct/10;
        }
				 System.out.print(""); 
        }
    }