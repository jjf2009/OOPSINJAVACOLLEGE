import java.util.Scanner;
public class BinToOct {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Your Binary Number:");
        int bin = sc.nextInt();
        System.out.println("Your Binary Number: " + bin);
        
        // Binary to Decimal
        int dec = 0;
        int base = 1;
        while (bin > 0) {
            int x = bin % 10;
            dec += x * base;
            base *= 2;
            bin = bin / 10;
        }
        System.out.println("Your Decimal Number: " + dec); 
        
        // Decimal to Octal
        String oct = "";  // Use String to avoid reversal issues
        int temp = dec;
        
        if (temp == 0) {
            oct = "0";
        } else {
            while (temp > 0) {
                int x = temp % 8;
                oct = x + oct;  // Prepend digit to get correct order
                temp = temp / 8;
            }
        }
        
        System.out.println("Your Octal Number: " + oct);
        sc.close();
    }
}
