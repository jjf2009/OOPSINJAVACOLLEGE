// Shopping Cart: Item with private name, price, quantity; total cost
class Item {
    private String name;
    private double price;
    private int quantity;

    Item(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    double cost() {
        return price * quantity;
    }

    void display() {
        System.out.println(name + " | " + price + " x " + quantity + " = " + cost());
    }
}

public class ShoppingCartSystem {
    public static void main(String[] args) {
        Item[] cart = {
            new Item("Notebook", 50, 3),
            new Item("Pen", 10, 5),
            new Item("Bag", 400, 1),
            new Item("USB Cable", 150, 2)
        };

        double total = 0;
        System.out.println("--- Shopping Cart ---");
        for (Item item : cart) {
            item.display();
            total += item.cost();
        }
        System.out.println("Total cost: " + total);
    }
}
