import java.io.*;
import java.util.*;

class ProductNotFoundException extends Exception {
    ProductNotFoundException(String msg) {
        super(msg);
    }
}

interface Manageable {
    void addProduct(String name);
    void removeProduct(String name) throws ProductNotFoundException;
}

class Inventory implements Manageable {
    Vector<String> products = new Vector<>();

    public void addProduct(String name) {
        products.add(name);
        System.out.println("Added: " + name);
    }

    public void removeProduct(String name) throws ProductNotFoundException {
        if (!products.contains(name)) {
            throw new ProductNotFoundException(name + " not found in inventory");
        }
        products.remove(name);
        System.out.println("Removed: " + name);
    }

    void saveToFile() throws IOException {
        FileWriter fw = new FileWriter("inventory.txt");
        for (String p : products) {
            fw.write(p + "\n");
        }
        fw.close();
        System.out.println("Saved to inventory.txt");
    }
}

public class ProductInventory {
    public static void main(String[] args) {
        Inventory inv = new Inventory();
        try {
            inv.addProduct("Laptop");
            inv.addProduct("Mouse");
            inv.addProduct("Keyboard");
            inv.removeProduct("Mouse");
            inv.saveToFile();

            inv.removeProduct("Phone"); // does not exist
        } catch (ProductNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}
