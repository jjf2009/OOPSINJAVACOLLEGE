abstract class Shape {
    String name;

    Shape(String name) {
        this.name = name;
    }

    abstract double calculateArea();
}

class Rectangle extends Shape {
    double length, width;

    Rectangle(double length, double width) {
        super("Rectangle");
        this.length = length;
        this.width = width;
    }

    double calculateArea() {
        return length * width;
    }
}

class Circle extends Shape {
    double radius;

    Circle(double radius) {
        super("Circle");
        this.radius = radius;
    }

    double calculateArea() {
        return 3.14 * radius * radius;
    }

    double circumference() {
        return 2 * 3.14 * radius;
    }
}

public class ShapeAreaCalculator {
    static Shape largestArea(Shape[] arr) {
        Shape max = arr[0];
        for (Shape s : arr) {
            if (s.calculateArea() > max.calculateArea()) {
                max = s;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Shape[] shapes = {
            new Rectangle(5, 4),
            new Circle(3),
            new Rectangle(10, 2),
            new Circle(5)
        };

        System.out.println("--- Areas ---");
        for (Shape s : shapes) {
            System.out.println(s.name + " area = " + s.calculateArea());
            // if Circle, also print circumference
            if (s.name.equals("Circle")) {
                Circle c = (Circle) s;
                System.out.println("  Circumference = " + c.circumference());
            }
        }

        Shape big = largestArea(shapes);
        System.out.println("Largest area: " + big.name + " (" + big.calculateArea() + ")");
    }
}
