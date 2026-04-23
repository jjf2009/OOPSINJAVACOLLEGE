
class Account {
    private String accountNumber;
    private String accountHolder;

     Account(String accountNumber, String accountHolder) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
    }

    public String getAccountNumber() { return accountNumber; }
    public String getAccountHolder()  { return accountHolder; }

    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }
    public void setAccountHolder(String accountHolder) { this.accountHolder = accountHolder; }

    @Override
    public String toString() {
        return "Account Number : " + accountNumber +
               "\nAccount Holder : " + accountHolder;
    }
}

class SavingsAccount extends Account {
    private double interestRate;

     SavingsAccount(String accountNumber, String accountHolder, double interestRate) {
        super(accountNumber, accountHolder);   
        this.interestRate = interestRate;
    }

    public double getInterestRate() { return interestRate; }

    public void setInterestRate(double interestRate) { this.interestRate = interestRate; }

    @Override
    public String toString() {
        return super.toString() +"\nInterest Rate  : " + interestRate + "%";
    }
}

public class SavingsAccountSystem {
    public static void main(String[] args) {

        java.util.Scanner sc = new java.util.Scanner(System.in);

        System.out.print("Enter Account Number: ");
        String accountNumber = sc.nextLine();

        System.out.print("Enter Account Holder: ");
        String accountHolder = sc.nextLine();

        System.out.print("Enter Interest Rate: ");
        double interestRate = sc.nextDouble();

        SavingsAccount sa = new SavingsAccount(accountNumber, accountHolder, interestRate);
        System.out.println("\n--- Account Details ---");
        System.out.println(sa);

        System.out.print("\nEnter Updated Interest Rate: ");
        sa.setInterestRate(sc.nextDouble());

        System.out.println("\n--- After Updating Interest Rate ---");
        System.out.println(sa);
    }
}