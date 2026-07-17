abstract class Product {
    String name;
    double price;

    Product(String name, double price) {
        this.name = name.trim().toUpperCase();
        this.price = price;
    }

    abstract String getCategory();

    double getBillPrice() {
        double p = price;
        // discount based on category
        if (getCategory().equals("Grocery")) {
            p = p * 0.95; // 5% off
        } else if (getCategory().equals("Electronics")) {
            p = p * 0.90; // 10% off
        }
        return p;
    }
}

class Grocery extends Product {
    Grocery(String name, double price) {
        super(name, price);
    }

    String getCategory() {
        return "Grocery";
    }
}

class Electronics extends Product {
    Electronics(String name, double price) {
        super(name, price);
    }

    String getCategory() {
        return "Electronics";
    }
}

public class SupermarketBilling {
    static void displayAll(Product[] items) {
        for (Product p : items) {
            System.out.println(p.name + " | " + p.getCategory() + " | " + p.getBillPrice());
        }
    }

    static void billingSummary(Product[] items) {
        double total = 0;
        for (Product p : items) {
            total += p.getBillPrice();
        }
        System.out.println("Total Bill: " + total);
    }

    public static void main(String[] args) {
        Product[] items = {
            new Grocery("  milk  ", 50),
            new Electronics("laptop", 40000),
            new Grocery("bread", 40),
            new Electronics("mouse", 500)
        };

        System.out.println("--- Items ---");
        displayAll(items);
        System.out.println("--- Summary ---");
        billingSummary(items);
    }
}
