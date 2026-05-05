import java.util.Scanner;

class InsufficientFundsException extends Exception {
    private double availableBalance;
    private double requestedAmount;

    public InsufficientFundsException() {
        super("Insufficient funds.");
        this.availableBalance = 0.0;
        this.requestedAmount = 0.0;
    }

    public InsufficientFundsException(double availableBalance, double requestedAmount) {
        super("Cannot withdraw ₹" + String.format("%.2f", requestedAmount)
                + ". Available balance: ₹" + String.format("%.2f", availableBalance));
        this.availableBalance = availableBalance;
        this.requestedAmount = requestedAmount;
    }

    public double getAvailableBalance() {
        return availableBalance;
    }

    public double getRequestedAmount() {
        return requestedAmount;
    }

    @Override
    public String toString() {
        return "InsufficientFundsException{requestedAmount=" + String.format("%.2f", requestedAmount)
                + ", availableBalance=" + String.format("%.2f", availableBalance) + "}";
    }
}

class ATM {
    private double balance;

    public ATM() {
        this.balance = 0.0;
    }

    public ATM(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        if (amount > balance) {
            throw new InsufficientFundsException(balance, amount);
        }
        balance -= amount;
        System.out.println("Withdrawal successful: ₹" + String.format("%.2f", amount));
    }

    @Override
    public String toString() {
        return "ATM Details\nCurrent Balance: ₹" + String.format("%.2f", balance);
    }
}

public class ATMExceptionDemo {
    public ATMExceptionDemo() {
    }

    public ATMExceptionDemo(String ignored) {
    }

    private static void attemptWithdrawal(ATM atm, double amount) {
        try {
            atm.withdraw(amount);
        } catch (InsufficientFundsException e) {
            System.out.println("Checked Exception Caught: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Unchecked Exception Caught: " + e.getMessage());
        } finally {
            System.out.println("Current Balance After Attempt: ₹" + String.format("%.2f", atm.getBalance()));
            System.out.println("---------------------------------------------------");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("=== ATM Exception Handling Demo ===");
            System.out.print("Enter initial ATM balance: ");
            double initialBalance = scanner.nextDouble();

            ATM atm = new ATM(initialBalance);
            System.out.println();
            System.out.println(atm);
            System.out.println();

            System.out.print("Enter first withdrawal amount (try non-positive to trigger IllegalArgumentException): ");
            double amount1 = scanner.nextDouble();
            attemptWithdrawal(atm, amount1);

            System.out.print("Enter second withdrawal amount (try more than balance to trigger InsufficientFundsException): ");
            double amount2 = scanner.nextDouble();
            attemptWithdrawal(atm, amount2);
        } finally {
            scanner.close();
        }
    }
}
