class SavingsAccount {
    private int accountNumber;
    private String name;
    private double balance;

    public SavingsAccount(int accountNumber, String name, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }

    public void applyInterest(double rate) {
        balance += balance * rate / 100;
    }

    public void display() {
        System.out.println("Account No: " + accountNumber +
                ", Name: " + name +
                ", Balance: " + balance);
    }
}

public class SavingsAccountSystem {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Enter number of accounts: ");
        int n = sc.nextInt();
        SavingsAccount[] accounts = new SavingsAccount[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for account " + (i + 1) + " (accountNumber name balance):");
            int accNo = sc.nextInt();
            String name = sc.next();
            double balance = sc.nextDouble();
            accounts[i] = new SavingsAccount(accNo, name, balance);
        }

        double interestRate = 5.0;

        for (SavingsAccount acc : accounts) {
            acc.applyInterest(interestRate);
            acc.display();
        }
    }
}