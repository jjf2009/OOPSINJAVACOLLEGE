interface Vehicle {
    void start();
    void stop();
}

class Car implements Vehicle {
    private String model;

    public Car(String model) {
        this.model = model;
    }

    @Override
    public void start() {
        System.out.println(model + " car started.");
    }

    @Override
    public void stop() {
        System.out.println(model + " car stopped.");
    }
}

public class VehicleCar {
    public static void main(String[] args) {
        Vehicle car = new Car("Sedan");
        car.start();
        car.stop();
    }
}