interface Calculator {
    int add(int a, int b);
}

class SimpleCalculator implements Calculator {
    @Override
    public int add(int a, int b) {
        return a + b;
    }
}

public class CalculatorAdd {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);

        System.out.print("Enter first number: ");
        int a = sc.nextInt();
        System.out.print("Enter second number: ");
        int b = sc.nextInt();

        Calculator calc = new SimpleCalculator();
        System.out.println("Sum: " + calc.add(a, b));

        sc.close();
    }
}