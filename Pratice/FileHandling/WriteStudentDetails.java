import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WriteStudentDetails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter roll number: ");
        int rollNo = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter course: ");
        String course = sc.nextLine();

        try (FileWriter writer = new FileWriter("student.txt")) {
            writer.write("Roll No: " + rollNo + "\n");
            writer.write("Name: " + name + "\n");
            writer.write("Course: " + course + "\n");
            System.out.println("Student details written to student.txt");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}