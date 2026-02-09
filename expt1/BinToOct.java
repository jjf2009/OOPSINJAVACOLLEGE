import java.util.Scanner;

public class BinToOct {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        System.out.println("Enter Your Binary Number:");
		     int bin = sc.nextInt();
		System.out.println("Your Binary Number:"+bin);
        double dec = 0;
		int i =1;
        while (bin > 0) {
            int x = bin % 10;
            dec= dec + x*Math.pow(2,i);
            bin = bin / 10;
			i++;
        }
            System.out.println("Your Decimal Number:"+dec); 
			int oct=0;
			 while (dec > 0) {
            int x = bin % 8;
            oct = oct *10+x;
            dec=dec/10;
        }
		 System.out.println("Your Octet Number:"+oct); 
        }
    }
