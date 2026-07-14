
interface Vehicle{
    void start();
    void stop();
}

class Car implements Vehicle{
    public void start(){
        System.out.println("Car has Started");
    }

    public void stop(){
        System.out.println("Car has stopped");
    }
}

public class VehicleCar {
        public static void main(String[] args) {
            Car c = new Car();
            c.start();
            c.stop();
        }
}
