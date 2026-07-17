abstract class Product {
    String productName;
    double price;

    Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
    }

    abstract String getCategory();
}

class GroceryProduct extends Product {
    double[] prices = new double[5];

    GroceryProduct(String productName, double price, double[] prices) {
        super(productName, price);
        this.prices = prices;
    }

    String getCategory() {
        return "Grocery";
    }

    double getTotalCost() {
        double sum = 0;
        for (double p : prices) {
            sum += p;
        }
        return sum;
    }

    String formatName() {
        if (productName == null || productName.isEmpty()) return productName;
        return productName.substring(0, 1).toUpperCase()
                + productName.substring(1).toLowerCase();
    }

    void checkBudget() {
        double total = getTotalCost();
        if (total <= 500) {
            System.out.println("In Budget");
        } else {
            System.out.println("Over Budget");
        }
    }
}

public class ProductInventoryTracker {
    public static void main(String[] args) {
        double[] rates = {50, 80, 120, 40, 100};
        GroceryProduct gp = new GroceryProduct("rice", 50, rates);

        // polymorphism
        Product ref = gp;
        System.out.println("Category: " + ref.getCategory());
        System.out.println("Name: " + gp.formatName());
        System.out.println("Total cost: " + gp.getTotalCost());
        gp.checkBudget();
    }
}
