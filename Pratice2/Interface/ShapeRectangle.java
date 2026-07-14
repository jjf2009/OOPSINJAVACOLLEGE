import java.util.Scanner;
interface Shape{
  double  calculateArea();
}

class Rectangle implements Shape {
      double b;
      double l;

    public Rectangle(double b, double l) {
        this.b = b;
        this.l = l;
    }


    @Override
     public double calculateArea(){
        return l*b;
      }
}

public class ShapeRectangle{
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
       System.out.print("Enter rectangle length: ");
        double length = sc.nextDouble();
        System.out.print("Enter rectangle width: ");
        double width = sc.nextDouble();

        Shape shape = new Rectangle(length, width);
        System.out.println("Area of Rectangle: " + shape.calculateArea());

    }
}