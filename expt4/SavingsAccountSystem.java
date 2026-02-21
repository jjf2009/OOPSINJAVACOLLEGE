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
        SavingsAccount[] accounts = {
                new SavingsAccount(101, "Rahul", 10000),
                new SavingsAccount(102, "Anita", 15000),
                new SavingsAccount(103, "Vikram", 20000)
        };

        double interestRate = 5.0;

        for (SavingsAccount acc : accounts) {
            acc.applyInterest(interestRate);
            acc.display();
        }
    }
}