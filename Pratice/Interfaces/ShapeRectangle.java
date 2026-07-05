interface Shape {
    double calculateArea();
}

class Rectangle implements Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }
}

public class ShapeRectangle {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);

        System.out.print("Enter rectangle length: ");
        double length = sc.nextDouble();
        System.out.print("Enter rectangle width: ");
        double width = sc.nextDouble();

        Shape shape = new Rectangle(length, width);
        System.out.println("Area of Rectangle: " + shape.calculateArea());

        sc.close();
    }
}