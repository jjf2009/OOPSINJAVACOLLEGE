// Laptop Store: private brand, RAM, price; show laptops with RAM > 8 GB
class Laptop {
    private String brand;
    private int ram;   // GB
    private double price;

    Laptop(String brand, int ram, double price) {
        this.brand = brand;
        this.ram = ram;
        this.price = price;
    }

    int getRam() {
        return ram;
    }

    void display() {
        System.out.println("Brand: " + brand + " | RAM: " + ram + " GB | Price: " + price);
    }
}

public class LaptopStore {
    public static void main(String[] args) {
        Laptop[] laptops = {
            new Laptop("Dell", 16, 55000),
            new Laptop("HP", 8, 40000),
            new Laptop("Lenovo", 32, 70000),
            new Laptop("Acer", 4, 30000),
            new Laptop("Asus", 12, 48000)
        };

        System.out.println("Laptops with RAM > 8 GB:");
        for (Laptop l : laptops) {
            if (l.getRam() > 8) {
                l.display();
            }
        }
    }
}
