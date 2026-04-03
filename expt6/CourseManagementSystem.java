import java.util.Scanner;

// Q3. Hierarchical Inheritance – Course Management

class Course {
    private String courseName;
    private String instructor;

    public Course(String courseName, String instructor) {
        this.courseName = courseName;
        this.instructor = instructor;
    }

    // Getters & Setters
    public String getCourseName()               { return courseName; }
    public String getInstructor()               { return instructor; }
    public void setCourseName(String courseName) { this.courseName = courseName; }
    public void setInstructor(String instructor) { this.instructor = instructor; }

    // To be overridden — enables dynamic binding
    public double calculateCourseFee() {
        return 0.0;
    }

    @Override
    public String toString() {
        return "Course     : " + courseName +
               "\nInstructor : " + instructor;
    }
}

class OnlineCourse extends Course {
    private int durationHours;
    private static final double RATE_PER_HOUR = 150.0;

    public OnlineCourse(String courseName, String instructor, int durationHours) {
        super(courseName, instructor);
        this.durationHours = durationHours;
    }

    // Getter & Setter
    public int getDurationHours()                { return durationHours; }
    public void setDurationHours(int durationHours) { this.durationHours = durationHours; }

    @Override
    public double calculateCourseFee() {
        return durationHours * RATE_PER_HOUR;
    }

    @Override
    public String toString() {
        return "[Online Course]\n" + super.toString() +
               "\nDuration   : " + durationHours + " hours" +
               "\nFee        : Rs. " + calculateCourseFee();
    }
}

class OfflineCourse extends Course {
    private int totalDays;
    private static final double DAILY_FEE = 500.0;
    private static final double LAB_FEE   = 2000.0;

    public OfflineCourse(String courseName, String instructor, int totalDays) {
        super(courseName, instructor);
        this.totalDays = totalDays;
    }

    // Getter & Setter
    public int getTotalDays()              { return totalDays; }
    public void setTotalDays(int totalDays) { this.totalDays = totalDays; }

    @Override
    public double calculateCourseFee() {
        // Fee = (days × daily fee) + lab fee
        return (totalDays * DAILY_FEE) + LAB_FEE;
    }

    @Override
    public String toString() {
        return "[Offline Course]\n" + super.toString() +
               "\nDuration   : " + totalDays + " days" +
               "\nFee        : Rs. " + calculateCourseFee();
    }
}

public class CourseManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Online Course Name:");
        String onlineCourseName = sc.nextLine();

        System.out.println("Enter Online Course Instructor:");
        String onlineInstructor = sc.nextLine();

        System.out.println("Enter Online Course Duration (in hours):");
        int onlineDurationHours = sc.nextInt();
        sc.nextLine(); // consume newline

        // Input for Offline Course
        System.out.println("Enter Offline Course Name:");
        String offlineCourseName = sc.nextLine();

        System.out.println("Enter Offline Course Instructor:");
        String offlineInstructor = sc.nextLine();

        System.out.println("Enter Offline Course Duration (in days):");
        int offlineTotalDays = sc.nextInt();

        // Normal variables used to create objects
        Course c1 = new OnlineCourse(onlineCourseName, onlineInstructor, onlineDurationHours);
        Course c2 = new OfflineCourse(offlineCourseName, offlineInstructor, offlineTotalDays);

        System.out.println("\n=== Course 1 ===");
        System.out.println(c1);

        System.out.println("\n=== Course 2 ===");
        System.out.println(c2);

        System.out.println("\n=== Fee Comparison ===");
        System.out.println(c1.getCourseName() + "Fee: Rs. " + c1.calculateCourseFee());
        System.out.println(c2.getCourseName() + "Fee: Rs. " + c2.calculateCourseFee());

        sc.close();
    }
}