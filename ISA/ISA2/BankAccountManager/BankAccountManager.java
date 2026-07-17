abstract class BankAccount {
    String ownerName;
    double balance;

    BankAccount(String ownerName, double balance) {
        this.ownerName = ownerName;
        this.balance = balance;
    }

    abstract String getAccountType();
}

class SavingsAccount extends BankAccount {
    double[] transactions = new double[5];
    int tCount = 0;

    SavingsAccount(String ownerName, double balance) {
        super(ownerName, balance);
    }

    String getAccountType() {
        return "Savings Account";
    }

    void addTransaction(double amount) {
        if (tCount < 5) {
            transactions[tCount++] = amount;
        } else {
            // shift left, keep last 5
            for (int i = 0; i < 4; i++) {
                transactions[i] = transactions[i + 1];
            }
            transactions[4] = amount;
        }
        balance += amount;
    }

    double totalTransactions() {
        double sum = 0;
        for (int i = 0; i < tCount && i < 5; i++) {
            sum += transactions[i];
        }
        // if full 5 after shifting, sum all 5
        if (tCount >= 5) {
            sum = 0;
            for (double t : transactions) sum += t;
        }
        return sum;
    }

    boolean hasFullName() {
        return ownerName.contains(" ");
    }

    void checkBalance(double threshold) {
        if (balance >= threshold) {
            System.out.println("Sufficient Balance");
        } else {
            System.out.println("Low Balance");
        }
    }
}

public class BankAccountManager {
    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount("John Doe", 3000);
        sa.addTransaction(500);
        sa.addTransaction(-200);
        sa.addTransaction(1000);
        sa.addTransaction(-100);
        sa.addTransaction(50);

        // polymorphism: subclass via abstract reference
        BankAccount ref = sa;
        System.out.println("Type: " + ref.getAccountType());
        System.out.println("Owner: " + sa.ownerName);
        System.out.println("Full name? " + sa.hasFullName());
        System.out.println("Total of last transactions: " + sa.totalTransactions());
        System.out.println("Balance: " + sa.balance);
        sa.checkBalance(5000);
    }
}
