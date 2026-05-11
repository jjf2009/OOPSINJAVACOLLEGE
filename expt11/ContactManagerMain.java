import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    String name;
    String phoneNumber;

    // Default constructor
    public Contact() {}

    // Parameterized constructor
    public Contact(String name, String phone) {
        this.name = name;
        this.phoneNumber = phone;
    }

    // Displays details in a user friendly format
    @Override
    public String toString() {
        return name + " (" + phoneNumber + ")";
    }
}

class ContactManager {
    // Groups contacts by first letter using nested iteration
    public void groupContacts(ArrayList<Contact> contacts) {
        ArrayList<Character> processedLetters = new ArrayList<>();
        for (Contact c : contacts) {
            if (c.name == null || c.name.isEmpty()) continue;
            
            char firstLetter = Character.toUpperCase(c.name.charAt(0));
            
            // Check if this group has already been printed
            if (!processedLetters.contains(firstLetter)) {
                System.out.println("\nGroup: " + firstLetter);
                
                // Nested iteration to find all matching contacts
                for (Contact match : contacts) {
                    if (match.name != null && !match.name.isEmpty() && 
                        Character.toUpperCase(match.name.charAt(0)) == firstLetter) {
                        System.out.println(" - " + match);
                    }
                }
                processedLetters.add(firstLetter);
            }
        }
    }
}

public class ContactManagerMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Contact> contactList = new ArrayList<>();
        ContactManager manager = new ContactManager();

        // All objects created through user input
        System.out.print("Enter number of contacts: ");
        int n = sc.nextInt();
        sc.nextLine(); // Consume newline

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Contact " + (i + 1) + ":");
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Phone Number: ");
            String phone = sc.nextLine();

            contactList.add(new Contact(name, phone));
        }

        System.out.println("\n--- Grouped Contacts ---");
        manager.groupContacts(contactList);

        sc.close();
    }
}