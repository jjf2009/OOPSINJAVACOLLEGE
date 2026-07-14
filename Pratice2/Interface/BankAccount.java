import java.util.Scanner;

interface Bank {
    double getInterestRate();
    
}

class SBI implements Bank {
    double interestrate;

    public SBI(double interestrate) {
        this.interestrate = interestrate;
    }
     @Override
    public double getInterestRate(){
         return interestrate;
    }
}

class HDFC implements Bank {
    double interestrate;

    public HDFC(double interestrate) {
        this.interestrate = interestrate;
    }
     @Override
    public double getInterestRate(){
         return interestrate;
    }
}


public class BankAccount {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
 System.out.println("Enter Interest Rate for SBI:");
    double rate = sc.nextDouble();
    Bank sbi = new SBI(rate);
     System.out.println("Enter Interest Rate for HDFC:");
    rate = sc.nextDouble();
    Bank Hdfc = new HDFC(rate);
    System.out.println("Interest Rate for SBI"+sbi.getInterestRate());
    System.out.println("Interest Rate for SBI"+Hdfc.getInterestRate());
    
    }
    
}
