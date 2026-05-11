import java.util.InputMismatchException;
import java.util.Scanner;

class InvalidMarksException extends Exception {
    private int marks;

    public InvalidMarksException() {
        super("Marks must be between 0 and 100.");
        this.marks = -1;
    }

    public InvalidMarksException(int marks) {
        super("Invalid marks: " + marks + ". Marks must be between 0 and 100.");
        this.marks = marks;
    }

    public int getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return "InvalidMarksException{marks=" + marks + "}";
    }
}

class Student {
    private String name;
    private int marks;

    public Student() {
        this.name = "Unknown";
        this.marks = 0;
    }

    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }

    public String calculateGrade() {
        if (marks >= 90) return "A+";
        if (marks >= 80) return "A";
        if (marks >= 70) return "B";
        if (marks >= 60) return "C";
        if (marks >= 50) return "D";
        return "F";
    }

    @Override
    public String toString() {
        return "Student Details\nName : " + name
                + "\nMarks: " + marks
                + "\nGrade: " + calculateGrade();
    }
}

public class StudentMarksProcessingSystem {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        char continueChoice = 'Y';

        while (continueChoice == 'Y' || continueChoice == 'y') {

            System.out.println("\n=== Student Marks Processing System ===");

            String name = "";
            int marks = -1;

            // LOOP FOR NAME
            while (true) {
                try {
                    System.out.print("Enter student name: ");
                    name = scanner.nextLine();

                    if (name == null || name.trim().isEmpty()) {
                        throw new IllegalArgumentException("Student name cannot be null or empty.");
                    }

                    break;

                } catch (IllegalArgumentException e) {
                    System.out.println("IllegalArgumentException Caught: " + e.getMessage());
                }
            }

            // LOOP FOR MARKS
            while (true) {
                try {
                    System.out.print("Enter marks (0-100): ");
                    marks = scanner.nextInt();

                    if (marks < 0 || marks > 100) {
                        throw new InvalidMarksException(marks);
                    }

                    break;

                } catch (InvalidMarksException e) {
                    System.out.println("Custom Checked Exception Caught: " + e.getMessage());
                } catch (InputMismatchException e) {
                    System.out.println("InputMismatchException Caught: Marks must be an integer.");
                    scanner.next();
                }
            }

            Student student = new Student(name.trim(), marks);

            System.out.println("\nProcessing Successful.");
            System.out.println(student);

            System.out.println("Processing completed for this student entry.");

            scanner.nextLine();

            System.out.print("Do you want to test another scenario? (Y/N): ");
            String response = scanner.nextLine();

            continueChoice = response.isEmpty() ? 'N' : response.charAt(0);
        }

        scanner.close();
        System.out.println("Application terminated.");
    }
}