import java.io.*;
import java.util.*;

// Custom exception for invalid marks
class InvalidMarksException extends Exception {
    InvalidMarksException(String msg) {
        super(msg);
    }
}

// Interface
interface Printable {
    void display();
}

// Student implements Printable
class Student implements Printable {
    String name;
    int marks;

    Student(String name, int marks) throws InvalidMarksException {
        if (marks < 0 || marks > 100) {
            throw new InvalidMarksException("Marks must be between 0 and 100");
        }
        this.name = name;
        this.marks = marks;
    }

    public void display() {
        System.out.println(name + " - " + marks);
    }
}

public class StudentMarksSaver {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();

        try {
            list.add(new Student("Alice", 85));
            list.add(new Student("Bob", 72));
            list.add(new Student("Charlie", 90));

            // Display all students
            System.out.println("Students:");
            for (Student s : list) {
                s.display();
            }

            // Write to file
            FileWriter fw = new FileWriter("students.txt");
            for (Student s : list) {
                fw.write(s.name + " " + s.marks + "\n");
            }
            fw.close();
            System.out.println("Saved to students.txt");

            // Try invalid marks
            list.add(new Student("Dave", 150));
        } catch (InvalidMarksException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}
