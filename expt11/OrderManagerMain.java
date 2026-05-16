import java.util.LinkedList;
import java.util.Scanner;

class Order {
    int orderId;
    String customerName;
    boolean isDelivered;

    public Order() {}

    public Order(int id, String name, boolean delivered) {
        this.orderId = id;
        this.customerName = name;
        this.isDelivered = delivered;
    }


    @Override
    public String toString() {
        return String.format("[ID: %d | Name: %s | Delivered: %b]", orderId, customerName, isDelivered);
    }
}

class OrderManager {
    public void partitionOrders(LinkedList<Order> list) {
        LinkedList<Order> undelivered = new LinkedList<>();
        LinkedList<Order> delivered = new LinkedList<>();
        for (Order o : list) {
            if (o.isDelivered) { 
                delivered.add(o);
            } else {
                undelivered.add(o);
            }
        }
        list.clear();
        list.addAll(undelivered);
        list.addAll(delivered);
    }
}

public class OrderManagerMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Order> orderList = new LinkedList<>();
        OrderManager manager = new OrderManager();

        System.out.print("Enter number of orders: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Order " + (i + 1) + ":");
            System.out.print("Order ID: ");
            int id = sc.nextInt();
            sc.nextLine(); // Consume newline
            System.out.print("Customer Name: ");
            String name = sc.nextLine();
            System.out.print("Is Delivered? (true/false): ");
            boolean delivered = sc.nextBoolean();

            orderList.add(new Order(id, name, delivered));
        }

        System.out.println("\nOriginal List:");
        for (Order o : orderList) System.out.println(o);

        manager.partitionOrders(orderList);

        System.out.println("\nRearranged List (Undelivered first):");
        for (Order o : orderList) System.out.println(o);

        sc.close();
    }
}