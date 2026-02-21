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

        Room[] rooms = {
                new Room(101, "Single", 2000, true),
                new Room(102, "Double", 3500, false),
                new Room(103, "Single", 2000, true),
                new Room(104, "Suite", 5000, true)
        };

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