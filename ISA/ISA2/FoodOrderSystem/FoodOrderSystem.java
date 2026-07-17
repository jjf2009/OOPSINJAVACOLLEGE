abstract class FoodItem {
    String name;
    double price;

    FoodItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    abstract double getPrice();
}

class MainCourse extends FoodItem {
    MainCourse(String name, double price) {
        super(name, price);
    }

    double getPrice() {
        return price;
    }
}

class Dessert extends FoodItem {
    Dessert(String name, double price) {
        super(name, price);
    }

    double getPrice() {
        return price;
    }
}

public class FoodOrderSystem {
    static double totalBill(FoodItem[] order) {
        double total = 0;
        for (FoodItem item : order) {
            double p = item.getPrice();
            // 10% surcharge if name contains "Special"
            if (item.name.contains("Special")) {
                p = p * 1.10;
            }
            total += p;
        }
        return total;
    }

    static void printDesserts(FoodItem[] order) {
        System.out.println("--- Desserts ---");
        for (FoodItem item : order) {
            if (item instanceof Dessert) {
                System.out.println(item.name + " : " + item.getPrice());
            }
        }
    }

    public static void main(String[] args) {
        FoodItem[] order = {
            new MainCourse("Pasta", 200),
            new MainCourse("Special Biryani", 350),
            new Dessert("Ice Cream", 100),
            new Dessert("Brownie", 120)
        };

        System.out.println("--- Order ---");
        for (FoodItem item : order) {
            System.out.println(item.name + " : " + item.getPrice());
        }
        System.out.println("Total bill: " + totalBill(order));
        printDesserts(order);
    }
}
