class Device {
    private String deviceName;

     Device(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceName()               { return deviceName; }
    public void setDeviceName(String deviceName) { this.deviceName = deviceName; }

    @Override
    public String toString() {
        return "Device Name  : " + deviceName;
    }
}

class Computer extends Device {
    private String processor;

    Computer(String deviceName, String processor) {
        super(deviceName);                         
        this.processor = processor;

    }

    public String getProcessor()              { return processor; }
    public void setProcessor(String processor) { this.processor = processor; }

    @Override
    public String toString() {
        return super.toString() +"\nProcessor    : " + processor;
    }
}

class Laptop extends Computer {
    private int batteryLife;   

    Laptop(String deviceName, String processor, int batteryLife) {
        super(deviceName, processor);              
        this.batteryLife = batteryLife;
       
    }

    public int getBatteryLife()              { return batteryLife; }
    public void setBatteryLife(int batteryLife) { this.batteryLife = batteryLife; }

    @Override
    public String toString() {
        return super.toString() +
               "\nBattery Life : " + batteryLife + " hours";
    }
}

public class DeviceSystem {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);

        System.out.println("=== Enter Laptop Details ===");
        System.out.print("Device Name: ");
        String deviceName = sc.nextLine();

        System.out.print("Processor: ");
        String processor = sc.nextLine();

        System.out.print("Battery Life (hours): ");
        int batteryLife = sc.nextInt();
        sc.nextLine(); 

        Laptop laptop = new Laptop(deviceName, processor, batteryLife);

        System.out.println("\n=== Complete Device Details ===");
        System.out.println(laptop);
        sc.close();
    }
}