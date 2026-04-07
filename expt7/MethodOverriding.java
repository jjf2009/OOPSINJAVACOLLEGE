// Q2. Method Overriding – Transport System

class Transport {
    private String transportName;
    private String route;

     Transport(String transportName, String route) {
        this.transportName = transportName;
        this.route         = route;
    }

    public String getTransportName()                   { return transportName; }
    public String getRoute()                           { return route; }
    public void   setTransportName(String name)        { this.transportName = name; }
    public void   setRoute(String route)               { this.route = route; }


    public double fare() {
        return 0.0;
    }

    @Override
    public String toString() {
        return "Transport : " + transportName +
               "\nRoute     : " + route +
               "\nFare      : Rs. " + fare();
    }
}

class Bus extends Transport {
    private static  double fare = 1.5;
    private double distanceKm;

    public Bus(String route, double distanceKm) {
        super("Bus", route);
        this.distanceKm     = distanceKm;
    }

    public double getDistanceKm()                        { return distanceKm; }
    public void   setDistanceKm(double distanceKm)       { this.distanceKm = distanceKm; }

    @Override
    public double fare() {
        double base = fare * distanceKm;
        return base;
    }

    @Override
    public String toString() {
        return "[Bus]\n" + super.toString() +
               "\nPassengers: " ;
    }
}

class Train extends Transport {
    private String classType;  // "Sleeper", "AC", "General"
    private double distanceKm;

     Train(String route, double distanceKm, String classType) {
        super("Train", route);
        this.distanceKm = distanceKm;
        this.classType  = classType;
    }

    public String getClassType()                  { return classType; }
    public double getDistanceKm()                 { return distanceKm; }
    public void   setClassType(String classType)  { this.classType = classType; }
    public void   setDistanceKm(double d)         { this.distanceKm = d; }

    @Override
    public double fare() {
        double rate;
        switch (classType) {
            case "AC":      rate = 3.5; break;
            case "Sleeper": rate = 2.0; break;
            default:        rate = 0.8; 
        }
        return rate * distanceKm;
    }

    @Override
    public String toString() {
        return "[Train]\n" + super.toString() +
               "\nClass     : " + classType;
    }
}

class Taxi extends Transport {
    private double distanceKm;
    private static final double fare = 12.0;

     Taxi(String route, double distanceKm) {
        super("Taxi", route);
        this.distanceKm = distanceKm;
    }

    // Getters & Setters
    public double getDistanceKm()           { return distanceKm; }
    public void   setDistanceKm(double d)   { this.distanceKm = d; }

    @Override
    public double fare() {
        return fare* distanceKm;
    }

    @Override
    public String toString() {
        return "[Taxi]\n" + super.toString() +
               "\nDistance  : " + distanceKm + " km";
    }
}

public class MethodOverriding {
    public static void main(String[] args) {

        java.util.Scanner sc = new java.util.Scanner(System.in);

        System.out.println("Enter Bus details:");
        System.out.print("Route: ");
        String busRoute = sc.nextLine();
        System.out.print("Distance (km): ");
        double busDistance = Double.parseDouble(sc.nextLine());
        System.out.println("\nEnter Train details:");
        System.out.print("Route: ");
        String trainRoute = sc.nextLine();
        System.out.print("Distance (km): ");
        double trainDistance = sc.nextDouble();
        sc.nextLine();
        System.out.print("Class (General/Sleeper/AC): ");
        String classType = sc.nextLine();

        System.out.println("\nEnter Taxi details:");
        System.out.print("Route: ");
        String taxiRoute = sc.nextLine();
        System.out.print("Distance (km): ");
        double taxiDistance = sc.nextDouble();

        Transport bus = new Bus(busRoute, busDistance);
        Transport train = new Train(trainRoute, trainDistance, classType);
        Transport taxi = new Taxi(taxiRoute, taxiDistance);
        System.out.println("\n=== Fare Summary ===");

        System.out.println(bus);
        System.out.println(train);
        System.out.println(taxi);

        sc.close();
    }
}