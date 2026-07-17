import java.io.*;
import java.util.*;

class DuplicateContactException extends Exception {
    DuplicateContactException(String msg) {
        super(msg);
    }
}

interface Saveable {
    void saveContact() throws DuplicateContactException;
}

class Contact implements Saveable {
    String name;
    String phone;
    static Vector<Contact> contacts = new Vector<>();

    Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public void saveContact() throws DuplicateContactException {
        for (Contact c : contacts) {
            if (c.name.equalsIgnoreCase(name)) {
                throw new DuplicateContactException(name + " already exists");
            }
        }
        contacts.add(this);
        System.out.println("Saved: " + name + " - " + phone);
    }

    static void writeToFile() throws IOException {
        FileWriter fw = new FileWriter("contacts.txt");
        for (Contact c : contacts) {
            fw.write(c.name + " " + c.phone + "\n");
        }
        fw.close();
        System.out.println("Written to contacts.txt");
    }
}

public class ContactBook {
    public static void main(String[] args) {
        try {
            new Contact("Alice", "9876543210").saveContact();
            new Contact("Bob", "9123456780").saveContact();
            new Contact("Charlie", "9000011111").saveContact();
            Contact.writeToFile();

            new Contact("Alice", "1111111111").saveContact(); // duplicate
        } catch (DuplicateContactException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}
