class BookInventory{
 private String title;
 private String author;
 private Double price;
 private static int instanceCount = 0;

    public BookInventory(String title,String author,Double price) {
        this.title=title;
        this.author=author;
        this.price=price;
        instanceCount++;
    }
    public void displayDetails(){
        System.out.println("Book Title:"+title+"Author Name:"+author+"Price of Book:"+price);
    }
    
    public void updatePrice(double newPrice){
        price=newPrice;
    }

    public static int getTotalBooks(){
        return instanceCount;
    }
 
}



public class BookInventorySystem {
        public static void main(String[] args) {

        java.util.Scanner sc = new java.util.Scanner(System.in);

        System.out.print("Enter number of books: ");
        int n = sc.nextInt();

        BookInventory[] books = new BookInventory[n];

        for(int i = 0; i < n; i++){

            System.out.println("Enter details (accountNumber name balance):");

            String title = sc.next();
            String author = sc.next();
            double price = sc.nextDouble();

            books[i] = new BookInventory(title, author, price);
        }

        System.out.println("total Number of Books: " + BookInventory.getTotalBooks());
    }
    
}
