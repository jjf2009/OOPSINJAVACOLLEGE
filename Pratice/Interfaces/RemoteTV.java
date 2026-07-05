interface Remote {
    void on();
    void off();
}

class TV implements Remote {
    private String brand;
    private boolean status;

    public TV(String brand) {
        this.brand = brand;
        this.status = false;
    }

    @Override
    public void on() {
        status = true;
        System.out.println(brand + " TV is ON.");
    }

    @Override
    public void off() {
        status = false;
        System.out.println(brand + " TV is OFF.");
    }
}

public class RemoteTV {
    public static void main(String[] args) {
        Remote tv = new TV("Samsung");
        tv.on();
        tv.off();
    }
}