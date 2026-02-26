import java.util.Scanner;

class Room {
    private int roomNumber;
    private String type;
    private double rent;
    private boolean available;

    public Room(int roomNumber, String type, double rent, boolean available) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.rent = rent;
        this.available = available;
    }

    public String getType() {
        return type;
    }

    public boolean isAvailable() {
        return available;
    }

    public void display() {
        System.out.println("Room No: " + roomNumber +
                ", Type: " + type +
                ", Rent: " + rent);
    }
}

public class HotelBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of rooms: ");
        int n = sc.nextInt();
        
        Room[] rooms = new Room[n];
        
        for (int i = 0; i < n; i++) {
            System.out.print("Enter room number: ");
            int roomNumber = sc.nextInt();
            sc.nextLine(); 
            
            System.out.print("Enter room type (Single/Double/Suite): ");
            String type = sc.nextLine();
            
            System.out.print("Enter rent: ");
            double rent = sc.nextDouble();
            sc.nextLine();
            
            System.out.print("Is available? (true/false): ");
            boolean available = sc.nextBoolean();
            sc.nextLine(); 
            
            rooms[i] = new Room(roomNumber, type, rent, available);
        }

        System.out.print("Enter room type to search (Single/Double/Suite): ");
        String choice = sc.nextLine();

        System.out.println("Available Rooms:");

        for (Room r : rooms) {
            if (r.getType().equalsIgnoreCase(choice) && r.isAvailable()) {
                r.display();
            }
        }
    }
}