abstract class Vehicle {
    String model;
    double dailyRate;

    Vehicle(String model, double dailyRate) {
        this.model = model;
        this.dailyRate = dailyRate;
    }

    abstract double getRentalCost(int days);

    double finalCost(int days) {
        double cost = getRentalCost(days);
        // discount if model name longer than 10 chars
        if (model.length() > 10) {
            cost = cost * 0.9; // 10% off
        }
        return cost;
    }
}

class Car extends Vehicle {
    Car(String model) {
        super(model, 1500);
    }

    double getRentalCost(int days) {
        return dailyRate * days;
    }
}

class Bike extends Vehicle {
    Bike(String model) {
        super(model, 500);
    }

    double getRentalCost(int days) {
        return dailyRate * days;
    }
}

public class VehicleRentalService {
    static Vehicle cheapest(Vehicle[] arr, int days) {
        Vehicle min = arr[0];
        for (Vehicle v : arr) {
            if (v.finalCost(days) < min.finalCost(days)) {
                min = v;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Vehicle[] vehicles = {
            new Car("HondaCity"),
            new Bike("Yamaha"),
            new Car("MercedesBenzS"),
            new Bike("RoyalEnfield")
        };

        int days = 5;
        System.out.println("--- Rental for " + days + " days ---");
        for (Vehicle v : vehicles) {
            System.out.println(v.model + " : " + v.finalCost(days));
        }

        Vehicle cheap = cheapest(vehicles, days);
        System.out.println("Cheapest: " + cheap.model + " (" + cheap.finalCost(days) + ")");
    }
}
