import java.util.Scanner;

class BookInventory {

    private String title;
    private String author;
    private double price;

    private static int totalBooks = 0;

    // Constructor
    BookInventory(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        totalBooks++;
    }

    // Instance Method: display details
    public void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
        System.out.println();
    }

    // Instance Method: update price
    public void updatePrice(double newPrice) {
        price = newPrice;
    }

    // Static Method: total books created
    public static int getTotalBooks() {
        return totalBooks;
    }
}

public class BookInventorySystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of books: ");
        int n = sc.nextInt();
        sc.nextLine();

        BookInventory[] books = new BookInventory[n];

        for (int i = 0; i < n; i++) {

            System.out.println("\nEnter details for Book " + (i + 1));

            System.out.print("Title: ");
            String title = sc.nextLine();

            System.out.print("Author: ");
            String author = sc.nextLine();

            System.out.print("Price: ");
            double price = sc.nextDouble();
            sc.nextLine();

            books[i] = new BookInventory(title, author, price);
        }

        System.out.println("\n--- Book Details ---");
        for (BookInventory b : books) {
            b.displayDetails();
        }

        System.out.println("Total Books Created: " + BookInventory.getTotalBooks());

        sc.close();
    }
}