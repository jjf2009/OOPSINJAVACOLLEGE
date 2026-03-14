import java.util.Scanner;

class Employee {

    int id;
    String name;
    double basic;
    double hra;
    double da;

    // Constructor
    Employee(int id, String name, double basic, double hra, double da) {
        this.id = id;
        this.name = name;
        this.basic = basic;
        this.hra = hra;
        this.da = da;
    }

    // Instance Method
    public double calculateGrossSalary() {
        return basic + hra + da;
    }

    // Static Method
    public static double calculateTotalSalary(Employee[] employees) {
        double total = 0;

        for (Employee e : employees) {
            total += e.calculateGrossSalary();
        }

        return total;
    }
}

public class EmployeeSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();
        sc.nextLine();

        Employee[] employees = new Employee[n];

        for (int i = 0; i < n; i++) {

            System.out.println("\nEmployee " + (i + 1));

            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Basic Salary: ");
            double basic = sc.nextDouble();

            System.out.print("Enter HRA: ");
            double hra = sc.nextDouble();

            System.out.print("Enter DA: ");
            double da = sc.nextDouble();

            employees[i] = new Employee(id, name, basic, hra, da);
        }

        System.out.println("\n--- Gross Salary of Employees ---");
        for (Employee e : employees) {
            System.out.println(e.name + " Gross Salary: " + e.calculateGrossSalary());
        }

        double totalSalary = Employee.calculateTotalSalary(employees);

        System.out.println("\nTotal Salary Payout for All Employees: " + totalSalary);

        sc.close();
    }
}