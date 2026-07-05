import java.util.Scanner;

class UnderAgeException extends Exception {
    public UnderAgeException(String message) {
        super(message);
    }
}

public class VotingEligibility {
    public static void checkEligibility(int age) throws UnderAgeException {
        if (age < 18) {
            throw new UnderAgeException("You are not eligible to vote.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your age: ");
        int age = sc.nextInt();

        try {
            checkEligibility(age);
            System.out.println("You are eligible to vote.");
        } catch (UnderAgeException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}