import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WriteEmployeeDetails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter employee ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter department: ");
        String dept = sc.nextLine();
        System.out.print("Enter salary: ");
        double salary = sc.nextDouble();

        try (FileWriter writer = new FileWriter("employee.txt")) {
            writer.write("ID: " + id + "\n");
            writer.write("Name: " + name + "\n");
            writer.write("Department: " + dept + "\n");
            writer.write("Salary: " + salary + "\n");
            System.out.println("Employee details saved to employee.txt");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}