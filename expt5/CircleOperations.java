class Circle{
    private Double radius;

    public Circle(Double r){
           radius=r;
    }

    public Double calculateArea(){
        return  Math.PI * radius * radius;
    }
    
    public Double calculateCircumference(){
        return 2*Math.PI*radius;
    }

    public static Circle compareRadius(Circle c1, Circle c2){
        return c1.radius>c2.radius ? c1 :c2;
    }
}


public class CircleOperations {
        public static void main(String[] args) {

        java.util.Scanner sc = new java.util.Scanner(System.in);

        System.out.print("Enter number of circles: ");
        int n = sc.nextInt();

        Circle[] circles = new Circle[n];

        for(int i = 0; i < n; i++){

            System.out.println("Enter details (accountNumber name balance):");

            double radius = sc.nextDouble();

            circles[i] = new Circle(radius);
        }
for(int i=1;i<=circles.length;i++){
    System.out.println("Area of Circle"+i+":"+circles[i].calculateArea());
    System.out.println("Circumference of Circle"+i+":"+circles[i].calculateCircumference());
}
        System.out.print("Enter index of circles1: ");
        int n1 = sc.nextInt();
        System.out.print("Enter index of circles2: ");
        int n2 = sc.nextInt();

        
    }
}
