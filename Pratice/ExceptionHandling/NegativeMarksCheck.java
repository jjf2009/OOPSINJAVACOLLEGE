import java.util.Scanner;

class NegativeMarksException extends Exception {
    public NegativeMarksException(String message) {
        super(message);
    }
}

public class NegativeMarksCheck {
    public static void validateMarks(int marks) throws NegativeMarksException {
        if (marks < 0) {
            throw new NegativeMarksException("Marks cannot be negative.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter marks: ");
        int marks = sc.nextInt();

        try {
            validateMarks(marks);
            System.out.println("Marks accepted: " + marks);
        } catch (NegativeMarksException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}