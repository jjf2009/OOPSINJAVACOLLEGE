import java.io.*;
import java.util.*;

class Course {
    private String courseId;
    private String courseName;
    private double fee;

    public Course() {}
    public Course(String id, String name, double fee) {
        this.courseId = id;
        this.courseName = name;
        this.fee = fee;
    }

    public double getFee() { return fee; }

    @Override
    public String toString() { return courseId + ": " + courseName + " ($" + fee + ")"; }
}

public class CourseSystem {
    public static void main(String[] args) {
        double totalFees = 0;
        try (Scanner sc = new Scanner(new File("courses.txt"))) {
            while (sc.hasNextLine()) {
                String[] data = sc.nextLine().split(",");
                Course c = new Course(data[0], data[1], Double.parseDouble(data[2]));
                totalFees += c.getFee();
            }

            try (PrintWriter out = new PrintWriter("total_fees.txt")) {
                out.println("Total Enrollment Fees for all courses: " + totalFees);
            }
            System.out.println("Total fees calculated and saved to total_fees.txt");
        } catch (IOException e) { System.err.println("Error: " + e.getMessage()); }
    }
}