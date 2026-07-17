import java.io.*;
import java.util.*;

class StudentNotFoundException extends Exception {
    StudentNotFoundException(String msg) {
        super(msg);
    }
}

interface Trackable {
    void markAttendance() throws StudentNotFoundException;
}

class Student implements Trackable {
    String name;
    static String[] classList = {"Alice", "Bob", "Charlie", "Diana"};
    static LinkedList<String> present = new LinkedList<>();

    Student(String name) {
        this.name = name;
    }

    public void markAttendance() throws StudentNotFoundException {
        boolean found = false;
        for (String s : classList) {
            if (s.equalsIgnoreCase(name)) {
                found = true;
                break;
            }
        }
        if (!found) {
            throw new StudentNotFoundException(name + " is not on the class list");
        }
        present.add(name);
        System.out.println(name + " marked present");
    }
}

public class AttendanceTracker {
    public static void main(String[] args) {
        try {
            new Student("Alice").markAttendance();
            new Student("Bob").markAttendance();
            new Student("Charlie").markAttendance();

            // Write attendance to file
            FileWriter fw = new FileWriter("attendance.txt");
            fw.write("Today's Attendance:\n");
            for (String s : Student.present) {
                fw.write(s + "\n");
            }
            fw.close();
            System.out.println("Saved to attendance.txt");

            // Try unknown student
            new Student("Zara").markAttendance();
        } catch (StudentNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}
