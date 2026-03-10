
class BankAccount {

    private int accountNumber;
    private String name;
    private double balance;

    private static String bankName = "India Bank";

    public BankAccount(int accountNumber, String name, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }

    public void deposit(double amount){
        balance += amount;
    }

    public void withdraw(double amount){
        if(balance >= amount){
            balance -= amount;
        } else {
            System.out.println("Insufficient balance");
        }
    }

    public double checkBalance(){
        return balance;
    }

    public static void changeBankName(String name){
        bankName = name;
    }

    public void display(){
        System.out.println(
            "Bank: " + bankName +
            ", Account No: " + accountNumber +
            ", Name: " + name +
            ", Balance: " + balance
        );
    }
}

public class SavingsAccountSystem {

    public static void main(String[] args) {

        java.util.Scanner sc = new java.util.Scanner(System.in);

        System.out.print("Enter number of accounts: ");
        int n = sc.nextInt();

        BankAccount[] accounts = new BankAccount[n];

        for(int i = 0; i < n; i++){

            System.out.println("Enter details (accountNumber name balance):");

            int accNo = sc.nextInt();
            String name = sc.next();
            double balance = sc.nextDouble();

            accounts[i] = new BankAccount(accNo, name, balance);
        }

        BankAccount.changeBankName("National Bank");

        for(BankAccount acc : accounts){
            acc.deposit(500);
            acc.display();
        }
    }
}