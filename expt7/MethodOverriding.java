// Q2. Method Overriding – Transport System

class Transport {
    private String transportName;
    private String route;

    public Transport(String transportName, String route) {
        this.transportName = transportName;
        this.route         = route;
    }

    // Getters & Setters
    public String getTransportName()                   { return transportName; }
    public String getRoute()                           { return route; }
    public void   setTransportName(String name)        { this.transportName = name; }
    public void   setRoute(String route)               { this.route = route; }

    // Base method — overridden by each subclass
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
    private int    passengerCount;
    private static final double RATE_PER_KM = 1.5;
    private double distanceKm;

    public Bus(String route, double distanceKm, int passengerCount) {
        super("Bus", route);
        this.distanceKm     = distanceKm;
        this.passengerCount = passengerCount;
    }

    // Getters & Setters
    public int    getPassengerCount()                    { return passengerCount; }
    public double getDistanceKm()                        { return distanceKm; }
    public void   setPassengerCount(int passengerCount)  { this.passengerCount = passengerCount; }
    public void   setDistanceKm(double distanceKm)       { this.distanceKm = distanceKm; }

    @Override
    public double fare() {
        // Flat rate × distance, discount if group > 20
        double base = RATE_PER_KM * distanceKm;
        return passengerCount > 20 ? base * 0.9 : base;
    }

    @Override
    public String toString() {
        return "[Bus]\n" + super.toString() +
               "\nPassengers: " + passengerCount;
    }
}

class Train extends Transport {
    private String classType;  // "Sleeper", "AC", "General"
    private double distanceKm;

    public Train(String route, double distanceKm, String classType) {
        super("Train", route);
        this.distanceKm = distanceKm;
        this.classType  = classType;
    }

    // Getters & Setters
    public String getClassType()                  { return classType; }
    public double getDistanceKm()                 { return distanceKm; }
    public void   setClassType(String classType)  { this.classType = classType; }
    public void   setDistanceKm(double d)         { this.distanceKm = d; }

    @Override
    public double fare() {
        // Rate per km based on class
        double rate;
        switch (classType) {
            case "AC":      rate = 3.5; break;
            case "Sleeper": rate = 2.0; break;
            default:        rate = 0.8; // General
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
    private static final double BASE_FARE   = 50.0;
    private static final double RATE_PER_KM = 12.0;

    public Taxi(String route, double distanceKm) {
        super("Taxi", route);
        this.distanceKm = distanceKm;
    }

    // Getters & Setters
    public double getDistanceKm()           { return distanceKm; }
    public void   setDistanceKm(double d)   { this.distanceKm = d; }

    @Override
    public double fare() {
        // Base fare + rate × distance
        return BASE_FARE + (RATE_PER_KM * distanceKm);
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
        System.out.print("Passenger count: ");
        int passengerCount = Integer.parseInt(sc.nextLine());

        System.out.println("\nEnter Train details:");
        System.out.print("Route: ");
        String trainRoute = sc.nextLine();
        System.out.print("Distance (km): ");
        double trainDistance = Double.parseDouble(sc.nextLine());
        System.out.print("Class (General/Sleeper/AC): ");
        String classType = sc.nextLine();

        System.out.println("\nEnter Taxi details:");
        System.out.print("Route: ");
        String taxiRoute = sc.nextLine();
        System.out.print("Distance (km): ");
        double taxiDistance = Double.parseDouble(sc.nextLine());

        Transport bus = new Bus(busRoute, busDistance, passengerCount);
        Transport train = new Train(trainRoute, trainDistance, classType);
        Transport taxi = new Taxi(taxiRoute, taxiDistance);

        System.out.println("\n=== Fare Summary ===");
        Transport[] vehicles = { bus, train, taxi };
        for (Transport t : vehicles) {
            System.out.printf("%s | Route: %s | Fare: Rs. %.2f%n",
                t.getTransportName(), t.getRoute(), t.fare());
        }

        sc.close();
    }
}