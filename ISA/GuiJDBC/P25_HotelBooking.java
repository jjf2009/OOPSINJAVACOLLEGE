import java.awt.*;
import java.sql.*;
import javax.swing.*;

// 25. Hotel room booking - store booking details
public class P25_HotelBooking extends JFrame {
    JTextField roomField, guestField, daysField;

    public P25_HotelBooking() {
        setTitle("Hotel Room Booking");
        setSize(400, 220);
        setLayout(new GridLayout(4, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        roomField = new JTextField();
        guestField = new JTextField();
        daysField = new JTextField();
        JButton btn = new JButton("Book");

        add(new JLabel("Room No")); add(roomField);
        add(new JLabel("Guest Name")); add(guestField);
        add(new JLabel("Days")); add(daysField);
        add(new JLabel("")); add(btn);

        btn.addActionListener(e -> book());
        setVisible(true);
    }

    void book() {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO bookings(room_no, guest_name, days) VALUES (?,?,?)");
            ps.setString(1, roomField.getText());
            ps.setString(2, guestField.getText());
            ps.setInt(3, Integer.parseInt(daysField.getText()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Booking saved");
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) { new P25_HotelBooking(); }
}
