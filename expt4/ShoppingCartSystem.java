class Item {
    private String itemName;
    private double price;
    private int quantity;

    public Item(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return price * quantity;
    }

    public void displayItem() {
        System.out.println("Item: " + itemName +
                ", Price: " + price +
                ", Quantity: " + quantity +
                ", Total: " + getTotalPrice());
    }
}

public class ShoppingCartSystem {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();
        sc.nextLine(); 

        Item[] cart = new Item[n];

        for (int i = 0; i < n; i++) {
             System.out.println("Enter details for item " + (i + 1) + "name:");
            String name = sc.nextLine();
            System.out.println("Enter details for item " + (i + 1) + " price:");
            double price = sc.nextDouble();
            System.out.println("Enter details for item " + (i + 1) + "quantity:");
            int quantity = sc.nextInt();
            sc.nextLine(); 

            cart[i] = new Item(name, price, quantity);
        }

        double totalCost = 0;

        System.out.println("\nShopping Cart Details:");
        for (Item item : cart) {
            item.displayItem();
            totalCost += item.getTotalPrice();
        }

        System.out.println("\nTotal Shopping Cost: " + totalCost);

        sc.close();
    }
}