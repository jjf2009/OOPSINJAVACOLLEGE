abstract class Accommodation {
    String hotelName;

    Accommodation(String hotelName) {
        this.hotelName = hotelName;
    }

    abstract String getRoomType();
}

class HotelRoom extends Accommodation {
    double[] nightlyRates = new double[5];

    HotelRoom(String hotelName, double[] rates) {
        super(hotelName);
        this.nightlyRates = rates;
    }

    String getRoomType() {
        return "Deluxe Room";
    }

    double getTotalCost() {
        double sum = 0;
        for (double r : nightlyRates) {
            sum += r;
        }
        return sum;
    }

    String formatHotelName() {
        if (hotelName.length() > 10) {
            return hotelName.substring(0, 10); // shortened
        }
        return hotelName;
    }

    void checkStay() {
        if (getTotalCost() > 5000) {
            System.out.println("Premium Stay");
        } else {
            System.out.println("Affordable Stay");
        }
    }
}

public class HotelRoomBookingSystem {
    public static void main(String[] args) {
        double[] rates = {1200, 1200, 1500, 1500, 1800};
        HotelRoom room = new HotelRoom("GrandPalaceHotel", rates);

        // polymorphism
        Accommodation ref = room;
        System.out.println("Room type: " + ref.getRoomType());
        System.out.println("Hotel: " + room.formatHotelName());
        System.out.println("Total: " + room.getTotalCost());
        room.checkStay();
    }
}
