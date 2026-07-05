import java.util.Scanner;

class ShortPasswordException extends Exception {
    public ShortPasswordException(String message) {
        super(message);
    }
}

public class PasswordLengthCheck {
    public static void validatePassword(String password) throws ShortPasswordException {
        if (password.length() < 6) {
            throw new ShortPasswordException("Password must be at least 6 characters.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        try {
            validatePassword(password);
            System.out.println("Password accepted.");
        } catch (ShortPasswordException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}