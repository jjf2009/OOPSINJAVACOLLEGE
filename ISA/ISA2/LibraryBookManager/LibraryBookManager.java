abstract class LibraryItem {
    String title;

    LibraryItem(String title) {
        this.title = title;
    }

    abstract String getDetails();
}

class Book extends LibraryItem {
    String author;

    Book(String title, String author) {
        super(title);
        this.author = author;
    }

    String getDetails() {
        return "Book: " + title + " by " + author;
    }
}

class Magazine extends LibraryItem {
    int issue;

    Magazine(String title, int issue) {
        super(title);
        this.issue = issue;
    }

    String getDetails() {
        return "Magazine: " + title + " Issue " + issue;
    }
}

public class LibraryBookManager {
    static void countByType(LibraryItem[] items) {
        int books = 0, mags = 0;
        for (LibraryItem item : items) {
            if (item instanceof Book) books++;
            else if (item instanceof Magazine) mags++;
        }
        System.out.println("Books: " + books + ", Magazines: " + mags);
    }

    public static void main(String[] args) {
        LibraryItem[] items = {
            new Book("Java Basics", "Herbert"),
            new Magazine("Tech Today", 12),
            new Book("Python Guide", "Alice"),
            new Magazine("Java World", 5)
        };

        System.out.println("--- Library Items ---");
        for (LibraryItem item : items) {
            System.out.println(item.getDetails());
            if (item.title.contains("Java")) {
                System.out.println("  ** Special: Java related item! **");
            }
        }

        countByType(items);
    }
}
