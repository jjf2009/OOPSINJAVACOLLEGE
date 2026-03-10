
class TemperatureConverter {

    private  static double c;
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








public class TemperatureConverterSystem {
    
}
