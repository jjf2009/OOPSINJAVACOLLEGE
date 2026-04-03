// Q2. Order Processing System – Abstract Class

abstract class Order {
    private String orderId;
    private String customerName;
    private double totalAmount;
    private String status;

    public Order(String orderId, String customerName, double totalAmount) {
        this.orderId      = orderId;
        this.customerName = customerName;
        this.totalAmount  = totalAmount;
        this.status       = "PENDING";
    }

    // Getters & Setters
    public String getOrderId()                  { return orderId; }
    public String getCustomerName()             { return customerName; }
    public double getTotalAmount()              { return totalAmount; }
    public String getStatus()                   { return status; }
    public void   setOrderId(String id)         { this.orderId = id; }
    public void   setCustomerName(String name)  { this.customerName = name; }
    public void   setTotalAmount(double amt)    { this.totalAmount = amt; }
    public void   setStatus(String status)      { this.status = status; }

    // Abstract method — each order type processes differently
    public abstract void processOrder();

    // Final method — cannot be overridden; invoice format stays consistent
    public final void generateInvoice() {
        System.out.println("========================================");
        System.out.println("            INVOICE                     ");
        System.out.println("========================================");
        System.out.println("Order ID    : " + orderId);
        System.out.println("Customer    : " + customerName);
        System.out.printf ("Amount      : Rs. %.2f%n", totalAmount);
        System.out.println("Status      : " + status);
        System.out.println("========================================");
    }

    @Override
    public String toString() {
        return "Order ID   : " + orderId +
               "\nCustomer   : " + customerName +
               String.format("%nAmount     : Rs. %.2f", totalAmount) +
               "\nStatus     : " + status;
    }
}

class OnlineOrder extends Order {
    private String deliveryAddress;
    private String paymentMethod;
    private int    estimatedDays;

    public OnlineOrder(String orderId, String customerName, double totalAmount,
                       String deliveryAddress, String paymentMethod, int estimatedDays) {
        super(orderId, customerName, totalAmount);
        this.deliveryAddress = deliveryAddress;
        this.paymentMethod   = paymentMethod;
        this.estimatedDays   = estimatedDays;
    }

    // Getters & Setters
    public String getDeliveryAddress()                    { return deliveryAddress; }
    public String getPaymentMethod()                      { return paymentMethod; }
    public int    getEstimatedDays()                      { return estimatedDays; }
    public void   setDeliveryAddress(String addr)         { this.deliveryAddress = addr; }
    public void   setPaymentMethod(String method)         { this.paymentMethod = method; }
    public void   setEstimatedDays(int days)              { this.estimatedDays = days; }

    @Override
    public void processOrder() {
        System.out.println("[Online Order] Processing order " + getOrderId() + "...");
        System.out.println("  → Verifying payment via " + paymentMethod + "...");
        System.out.println("  → Payment confirmed.");
        System.out.println("  → Dispatching to: " + deliveryAddress);
        System.out.println("  → Estimated delivery: " + estimatedDays + " business days.");
        setStatus("DISPATCHED");
        System.out.println("  → Status updated to: " + getStatus());
    }

    @Override
    public String toString() {
        return "[Online Order]\n" + super.toString() +
               "\nAddress    : " + deliveryAddress +
               "\nPayment    : " + paymentMethod +
               "\nETA        : " + estimatedDays + " days";
    }
}

class StoreOrder extends Order {
    private String storeBranch;
    private String staffName;

    public StoreOrder(String orderId, String customerName, double totalAmount,
                      String storeBranch, String staffName) {
        super(orderId, customerName, totalAmount);
        this.storeBranch = storeBranch;
        this.staffName   = staffName;
    }

    // Getters & Setters
    public String getStoreBranch()                  { return storeBranch; }
    public String getStaffName()                    { return staffName; }
    public void   setStoreBranch(String branch)     { this.storeBranch = branch; }
    public void   setStaffName(String name)         { this.staffName = name; }

    @Override
    public void processOrder() {
        System.out.println("[Store Order] Processing order " + getOrderId() + "...");
        System.out.println("  → Branch    : " + storeBranch);
        System.out.println("  → Staff     : " + staffName);
        System.out.println("  → Items picked from shelf and billed at counter.");
        System.out.println("  → Cash/Card payment collected.");
        setStatus("COMPLETED");
        System.out.println("  → Status updated to: " + getStatus());
    }

    @Override
    public String toString() {
        return "[Store Order]\n" + super.toString() +
               "\nBranch     : " + storeBranch +
               "\nStaff      : " + staffName;
    }
}
public class Q2_OrderProcessing {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);

        // Online order input
        System.out.println("Enter Online Order Details:");
        System.out.print("Order ID: ");
        String onlineOrderId = sc.nextLine();

        System.out.print("Customer Name: ");
        String onlineCustomer = sc.nextLine();

        System.out.print("Total Amount: ");
        double onlineAmount = Double.parseDouble(sc.nextLine());

        System.out.print("Delivery Address: ");
        String address = sc.nextLine();

        System.out.print("Payment Method: ");
        String payment = sc.nextLine();

        System.out.print("Estimated Delivery Days: ");
        int eta = Integer.parseInt(sc.nextLine());

        // Store order input
        System.out.println("\nEnter Store Order Details:");
        System.out.print("Order ID: ");
        String storeOrderId = sc.nextLine();

        System.out.print("Customer Name: ");
        String storeCustomer = sc.nextLine();

        System.out.print("Total Amount: ");
        double storeAmount = Double.parseDouble(sc.nextLine());

        System.out.print("Store Branch: ");
        String branch = sc.nextLine();

        System.out.print("Staff Name: ");
        String staff = sc.nextLine();

        Order online = new OnlineOrder(onlineOrderId, onlineCustomer, onlineAmount, address, payment, eta);
        Order store  = new StoreOrder(storeOrderId, storeCustomer, storeAmount, branch, staff);

        System.out.println("\n=== Order Details ===\n");
        System.out.println(online);
        System.out.println();
        System.out.println(store);

        System.out.println("\n=== Processing Orders (Abstract Method) ===\n");
        online.processOrder();
        System.out.println();
        store.processOrder();

        System.out.println("\n=== Invoices (Final Method – cannot be overridden) ===\n");
        online.generateInvoice();
        System.out.println();
        store.generateInvoice();

        System.out.print("\nEnter discounted amount for Online Order: ");
        double discountedAmount = Double.parseDouble(sc.nextLine());
        online.setTotalAmount(discountedAmount);

        System.out.println("\n=== After Discount Applied to Online Order ===");
        System.out.println(online);

        sc.close();
    }
}