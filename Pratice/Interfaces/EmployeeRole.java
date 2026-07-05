interface Employee {
    void displayRole();
}

class Manager implements Employee {
    @Override
    public void displayRole() {
        System.out.println("Role: Manager - Manages team and projects.");
    }
}

class Developer implements Employee {
    @Override
    public void displayRole() {
        System.out.println("Role: Developer - Writes and maintains code.");
    }
}

public class EmployeeRole {
    public static void main(String[] args) {
        Employee manager = new Manager();
        Employee developer = new Developer();

        manager.displayRole();
        developer.displayRole();
    }
}