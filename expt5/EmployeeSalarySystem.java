
class Employee{
    private double hra;
    private double basic;
    private double da;

    public Employee(double hra,double basic,double da) {
        this.hra=hra;
        this.basic=basic;
        this.da=da;
    }
    public double calculateGrossSalary(){
        return (hra+basic+da);
    }
    
    public static double calculateTotalSalary(Employee[] employees){
        double totalSalary=0;
        for(Employee e : employees){
          totalSalary+=  e.calculateGrossSalary();
         
        }
        return totalSalary;
    }

}


public class EmployeeSalarySystem {
    public static void main(String[] args) {

        java.util.Scanner sc = new java.util.Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();

        Employee[] employees = new Employee[n];

        for(int i = 0; i < n; i++){

            System.out.println("Enter details (accountNumber name balance):");

            Double hra = sc.nextDouble();
            Double basic = sc.nextDouble();
            double da = sc.nextDouble();

            employees[i] = new Employee(hra, basic, da);
        }

        System.out.println("total salary payout for all employees: " + Employee.calculateTotalSalary(employees));
    }
}
