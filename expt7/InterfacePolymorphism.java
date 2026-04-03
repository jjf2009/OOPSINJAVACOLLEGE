// Q4. Polymorphism in Interfaces – Shape

interface Shape {
    // Contract — every implementing class MUST define these
    void   draw();
    double area();
    double perimeter();
}

class Circle implements Shape {
    private String color;
    private double radius;

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color  = color;
    }

    // Getters & Setters
    public double getRadius()           { return radius; }
    public String getColor()            { return color; }
    public void   setRadius(double r)   { this.radius = r; }
    public void   setColor(String c)    { this.color = c; }

    @Override
    public void draw() {
        System.out.println("[Circle] Drawing a " + color +
                " circle with radius " + radius + " units.");
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "[Circle]" +
               "\nColor       : " + color +
               "\nRadius      : " + radius +
               String.format("%nArea        : %.2f", area()) +
               String.format("%nCircumfrnce : %.2f", perimeter());
    }
}

class Square implements Shape {
    private String color;
    private double side;

    public Square(double side, String color) {
        this.side  = side;
        this.color = color;
    }

    // Getters & Setters
    public double getSide()           { return side; }
    public String getColor()          { return color; }
    public void   setSide(double s)   { this.side = s; }
    public void   setColor(String c)  { this.color = c; }

    @Override
    public void draw() {
        System.out.println("[Square] Drawing a " + color +
                " square with side " + side + " units.");
    }

    @Override
    public double area() {
        return side * side;
    }

    @Override
    public double perimeter() {
        return 4 * side;
    }

    @Override
    public String toString() {
        return "[Square]" +
               "\nColor     : " + color +
               "\nSide      : " + side +
               String.format("%nArea      : %.2f", area()) +
               String.format("%nPerimeter : %.2f", perimeter());
    }
}
public class InterfacePolymorphism {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);

        // User input
        System.out.print("Enter circle radius: ");
        double radius = sc.nextDouble();
        sc.nextLine(); // consume newline
        System.out.print("Enter circle color: ");
        String circleColor = sc.nextLine();

        System.out.print("Enter square side: ");
        double side = sc.nextDouble();
        sc.nextLine(); // consume newline
        System.out.print("Enter square color: ");
        String squareColor = sc.nextLine();

        // Interface polymorphism
        Shape[] shapes = {
            new Circle(radius, circleColor),
            new Square(side, squareColor)
        };

        System.out.println("\n=== Shape Details ===");
        for (Shape s : shapes) {
            s.draw();
            System.out.printf("Area: %.2f, Perimeter: %.2f%n%n", s.area(), s.perimeter());
        }

        sc.close();
    }
}