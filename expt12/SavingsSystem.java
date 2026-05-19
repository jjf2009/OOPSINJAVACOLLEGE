import java.io.*;
import java.util.*;

class SavingsAccount {
    private String accountNumber;
    private String name;
    private double balance;

    public SavingsAccount() {}
    public SavingsAccount(String acc, String name, double bal) {
        this.accountNumber = acc;
        this.name = name;
        this.balance = bal;
    }

    public void applyInterest(double rate) { balance += balance * rate; }

    @Override
    public String toString() {
        return String.format("Acc: %s | Name: %s | Balance: %.2f", accountNumber, name, balance);
    }
}

public class SavingsSystem {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(new File("input1.txt"));
             PrintWriter out = new PrintWriter(new FileWriter("output1.txt"))) {
            while (sc.hasNextLine()) {
                String[] data = sc.nextLine().split(",");
                SavingsAccount sa = new SavingsAccount(data[0], data[1], Double.parseDouble(data[2]));
                sa.applyInterest(0.04);
                String record = sa.toString();
                out.println(record);
                System.out.println(record);
            }
            System.out.println("Interest applied and saved to output1.txt");
        } catch (IOException e) { System.err.println("File Error: " + e.getMessage()); }
    }
}