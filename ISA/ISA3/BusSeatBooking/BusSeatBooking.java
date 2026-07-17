import java.io.*;
import java.util.*;

class SeatFullException extends Exception {
    SeatFullException(String msg) {
        super(msg);
    }
}

interface Bookable {
    void bookSeat(String name) throws SeatFullException;
    void cancelSeat(String name);
}

class Bus implements Bookable {
    static final int CAPACITY = 40;
    Vector<String> passengers = new Vector<>();

    public void bookSeat(String name) throws SeatFullException {
        if (passengers.size() >= CAPACITY) {
            throw new SeatFullException("Bus is full (capacity " + CAPACITY + ")");
        }
        passengers.add(name);
        System.out.println("Booked: " + name + " (seats: " + passengers.size() + "/" + CAPACITY + ")");
    }

    public void cancelSeat(String name) {
        if (passengers.remove(name)) {
            System.out.println("Cancelled: " + name);
        } else {
            System.out.println(name + " not found");
        }
    }

    void saveBookings() throws IOException {
        FileWriter fw = new FileWriter("bookings.txt");
        for (String p : passengers) {
            fw.write(p + "\n");
        }
        fw.close();
        System.out.println("Saved to bookings.txt");
    }
}

public class BusSeatBooking {
    public static void main(String[] args) {
        Bus bus = new Bus();
        try {
            bus.bookSeat("Alice");
            bus.bookSeat("Bob");
            bus.bookSeat("Charlie");
            bus.cancelSeat("Bob");
            bus.saveBookings();

            // Fill bus to show SeatFullException
            for (int i = 0; i < 40; i++) {
                bus.bookSeat("P" + i);
            }
        } catch (SeatFullException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}
