

interface Shape {
    void   draw();
}

class Circle implements Shape {
    private String color;
    private double radius;

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color  = color;
    }


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
    public String toString() {
        return "[Circle]" +
               "\nColor       : " + color +
               "\nRadius      : " + radius ;
    }
}

class Square implements Shape {
    private String color;
    private double side;

    public Square(double side, String color) {
        this.side  = side;
        this.color = color;
    }

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
    public String toString() {
        return "[Square]" +
               "\nColor     : " + color +
               "\nSide      : " + side ;
    }
}
public class InterfacePolymorphism {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Enter circle radius: ");
        double radius = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter circle color: ");
        String circleColor = sc.nextLine();

        System.out.print("Enter square side: ");
        double side = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter square color: ");
        String squareColor = sc.nextLine();

        Shape[] shapes = {
            new Circle(radius, circleColor),
            new Square(side, squareColor)
        };

        System.out.println("\n=== Shape Details ===");
        for (Shape s : shapes) {
            System.out.println(s);   // direct printing via toString()
            s.draw();
            System.out.println();
        }

        sc.close();
    }
}