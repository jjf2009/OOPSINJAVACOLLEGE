// Q4. Abstract Class – Payment System

abstract class Payment {
    private String payerName;
    private double amount;

    public Payment(String payerName, double amount) {
        this.payerName = payerName;
        this.amount    = amount;
    }

    public String getPayerName()             { return payerName; }
    public double getAmount()                { return amount; }
    public void setPayerName(String payerName) { this.payerName = payerName; }
    public void setAmount(double amount)       { this.amount = amount; }

    public abstract void processPayment();

    @Override
    public String toString() {
        return "Payer  : " + payerName +
               "\nAmount : Rs. " + amount;
    }
}

class CreditCardPayment extends Payment {
    private String cardNumber;
    private String bankName;

    public CreditCardPayment(String payerName, double amount,String cardNumber, String bankName) {
        super(payerName, amount);              
        this.cardNumber = cardNumber;
        this.bankName   = bankName;
    }

    public String getCardNumber()              { return cardNumber; }
    public String getBankName()                { return bankName; }
    public void setCardNumber(String cardNumber) { this.cardNumber = cardNumber; }
    public void setBankName(String bankName)     { this.bankName = bankName; }

    @Override
    public void processPayment() {
        System.out.println("[Credit Card Payment]");
        System.out.println(this);
        System.out.println("Payment of Rs. " + getAmount() +
                           " processed via " + bankName +
                           " card ending in " + cardNumber.substring(cardNumber.length() - 4));
        System.out.println("Status: SUCCESS\n");
    }

    @Override
    public String toString() {
        return super.toString() +
               "\nCard   : **** **** **** " + cardNumber.substring(cardNumber.length() - 4) +
               "\nBank   : " + bankName;
    }
}

class UPIPayment extends Payment {
    private String upiId;

    public UPIPayment(String payerName, double amount, String upiId) {
        super(payerName, amount);              // constructor chaining
        this.upiId = upiId;
    }

    // Getter & Setter
    public String getUpiId()           { return upiId; }
    public void setUpiId(String upiId)  { this.upiId = upiId; }

    @Override
    public void processPayment() {
        System.out.println("[UPI Payment]");
        System.out.println(this);
        System.out.println("Payment of Rs. " + getAmount() +
                           " sent to UPI ID: " + upiId);
        System.out.println("Status: SUCCESS\n");
    }

    @Override
    public String toString() {
        return super.toString() +
               "\nUPI ID : " + upiId;
    }
}

public class PaymentSystem {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);

        System.out.println("=== Payment System ===");
        System.out.print("Enter payer name: ");
        String payerName = sc.nextLine();

        System.out.print("Enter amount: ");
        double amount = sc.nextDouble();
        sc.nextLine(); 

        System.out.println("Choose payment type:");
        System.out.println("1. Credit Card");
        System.out.println("2. UPI");
        System.out.print("Enter choice (1/2): ");
        int choice = sc.nextInt();
        sc.nextLine(); 

        Payment payment;

        if (choice == 1) {
            System.out.print("Enter card number: ");
            String cardNumber = sc.nextLine();

            System.out.print("Enter bank name: ");
            String bankName = sc.nextLine();

            payment = new CreditCardPayment(payerName, amount, cardNumber, bankName);
        } else {
            System.out.print("Enter UPI ID: ");
            String upiId = sc.nextLine();

            payment = new UPIPayment(payerName, amount, upiId);
        }

        System.out.println("\n=== Processing Payment ===");
        payment.processPayment();

        sc.close();
    }
}