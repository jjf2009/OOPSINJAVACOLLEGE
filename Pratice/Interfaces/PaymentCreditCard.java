interface Payment {
    void payBill(double amount);
}

class CreditCard implements Payment {
    private String cardNumber;

    public CreditCard(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void payBill(double amount) {
        System.out.println("Paid Rs. " + amount + " using Credit Card " + cardNumber);
    }
}

public class PaymentCreditCard {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);

        System.out.print("Enter card number: ");
        String cardNumber = sc.nextLine();
        System.out.print("Enter bill amount: ");
        double amount = sc.nextDouble();

        Payment payment = new CreditCard(cardNumber);
        payment.payBill(amount);

        sc.close();
    }
}