import java.util.Scanner;

class Circle {

    double radius;

    // Constructor
    Circle(double radius) {
        this.radius = radius;
    }

    // Instance Method: Calculate Area
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    // Instance Method: Calculate Circumference
    public double calculateCircumference() {
        return 2 * Math.PI * radius;
    }

    // Static Method: Compare two circles
    public static Circle compareRadius(Circle c1, Circle c2) {
        if (c1.radius > c2.radius) {
            return c1;
        } else {
            return c2;
        }
    }
}

public class CircleSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter radius of first circle: ");
        double r1 = sc.nextDouble();

        System.out.print("Enter radius of second circle: ");
        double r2 = sc.nextDouble();

        Circle c1 = new Circle(r1);
        Circle c2 = new Circle(r2);

        System.out.println("\nCircle 1 Area: " + c1.calculateArea());
        System.out.println("Circle 1 Circumference: " + c1.calculateCircumference());

        System.out.println("\nCircle 2 Area: " + c2.calculateArea());
        System.out.println("Circle 2 Circumference: " + c2.calculateCircumference());

        Circle bigger = Circle.compareRadius(c1, c2);

        System.out.println("\nCircle with larger radius: " + bigger.radius);

        sc.close();
    }
}