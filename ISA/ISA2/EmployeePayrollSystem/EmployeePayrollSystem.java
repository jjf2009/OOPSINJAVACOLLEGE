// Abstract class + polymorphism
abstract class Employee {
    String name;
    double baseSalary;

    Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    abstract double calculateSalary();

    double getFinalSalary() {
        double sal = calculateSalary();
        // 5% bonus if name starts with "A"
        if (name.startsWith("A")) {
            sal = sal + sal * 0.05;
        }
        return sal;
    }
}

class FullTimeEmployee extends Employee {
    FullTimeEmployee(String name, double baseSalary) {
        super(name, baseSalary);
    }

    double calculateSalary() {
        return baseSalary; // fixed monthly
    }
}

class PartTimeEmployee extends Employee {
    int hours;
    double rate;

    PartTimeEmployee(String name, int hours, double rate) {
        super(name, 0);
        this.hours = hours;
        this.rate = rate;
    }

    double calculateSalary() {
        return hours * rate;
    }
}

public class EmployeePayrollSystem {
    static Employee highestPaid(Employee[] arr) {
        Employee max = arr[0];
        for (Employee e : arr) {
            if (e.getFinalSalary() > max.getFinalSalary()) {
                max = e;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Employee[] emp = {
            new FullTimeEmployee("Alice", 50000),
            new PartTimeEmployee("Bob", 80, 200),
            new FullTimeEmployee("Charlie", 45000),
            new PartTimeEmployee("Amit", 100, 150)
        };

        System.out.println("--- Payroll ---");
        for (Employee e : emp) {
            System.out.println(e.name + " : " + e.getFinalSalary());
        }

        Employee top = highestPaid(emp);
        System.out.println("Highest paid: " + top.name + " (" + top.getFinalSalary() + ")");
    }
}
