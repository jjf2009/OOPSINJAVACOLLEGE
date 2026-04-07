
interface Automation {
    void autoControl();
}

abstract class HomeDevice {
    private String deviceId;
    private String deviceName;
    private boolean isPoweredOn;

    public HomeDevice(String deviceId, String deviceName) {
        this.deviceId    = deviceId;
        this.deviceName  = deviceName;
        this.isPoweredOn = false;
    }


    public String  getDeviceId()                   { return deviceId; }
    public String  getDeviceName()                 { return deviceName; }
    public boolean isPoweredOn()                   { return isPoweredOn; }
    public void    setDeviceId(String id)          { this.deviceId = id; }
    public void    setDeviceName(String name)      { this.deviceName = name; }
    public void    setPoweredOn(boolean state)     { this.isPoweredOn = state; }

    public static String deviceCategory() {
        return "Smart Home Device";
    }

    public abstract void operate();

    @Override
    public String toString() {
        return "Device ID   : " + deviceId +
               "\nDevice Name : " + deviceName +
               "\nPower       : " + (isPoweredOn ? "ON" : "OFF") +
               "\nCategory    : " + deviceCategory();
    }
}


class SmartLight extends HomeDevice implements Automation {
    private int    brightnessLevel;   
    private String colorTemp;        
    private String mode;              

    public SmartLight(String deviceId, String deviceName,
                      int brightnessLevel, String colorTemp) {
        super(deviceId, deviceName);
        this.brightnessLevel = brightnessLevel;
        this.colorTemp       = colorTemp;
        this.mode            = "Manual";
    }

    // Getters & Setters
    public int    getBrightnessLevel()                  { return brightnessLevel; }
    public String getColorTemp()                        { return colorTemp; }
    public String getMode()                             { return mode; }
    public void   setBrightnessLevel(int level)         { this.brightnessLevel = Math.min(100, Math.max(0, level)); }
    public void   setColorTemp(String colorTemp)        { this.colorTemp = colorTemp; }
    public void   setMode(String mode)                  { this.mode = mode; }


    @Override
    public void operate() {
        if (!isPoweredOn()) {
            setPoweredOn(true);
            System.out.println("[SmartLight] " + getDeviceName() + " powered ON.");
        }
        System.out.println("[SmartLight] Operating in " + mode + " mode.");
        System.out.println("  → Brightness : " + brightnessLevel + "%");
        System.out.println("  → Color Temp : " + colorTemp);
    }


    @Override
    public void autoControl() {
        setMode("Auto");
        System.out.println("[Automation] " + getDeviceName() + " switching to AUTO mode.");
        System.out.println("  → Sunrise detected: dimming to 30%...");
        setBrightnessLevel(30);
        setColorTemp("Warm");
        System.out.println("  → Brightness set to " + brightnessLevel + "% | Temp: " + colorTemp);
    }

    @Override
    public String toString() {
        return "[SmartLight]\n" + super.toString() +
               "\nBrightness  : " + brightnessLevel + "%" +
               "\nColor Temp  : " + colorTemp +
               "\nMode        : " + mode;
    }
}

public class SmartHome {

    private static int clampBrightness(int value) {
        return Math.max(0, Math.min(100, value));
    }

    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);

        System.out.println("Enter SmartLight details:");
        System.out.print("Device ID: ");
        String id = sc.nextLine();

        System.out.print("Device Name: ");
        String name = sc.nextLine();

        System.out.print("Brightness (0-100): ");
        int brightness = clampBrightness(sc.nextInt());
        sc.nextLine(); 

        System.out.print("Color Temp (Warm/Cool/Daylight): ");
        String colorTemp = sc.nextLine();

        SmartLight light = new SmartLight(id, name, brightness, colorTemp);

        System.out.println("\n=== Device Details ===\n");
        System.out.println(light);

        // Static method — called on class, not instance
        System.out.println("\n=== Static Method ===");
        System.out.println("Category: " + HomeDevice.deviceCategory());

        System.out.println("\n=== operate() — Abstract Method from HomeDevice ===\n");
        light.operate();

        System.out.println("\n=== autoControl() — Interface Method from Automation ===\n");
        light.autoControl();
        sc.close();
    }
}