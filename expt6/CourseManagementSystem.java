import java.util.Scanner;


class Course {
    private String courseName;
    private String instructor;

     Course(String courseName, String instructor) {
        this.courseName = courseName;
        this.instructor = instructor;
    }

    public String getCourseName()               { return courseName; }
    public String getInstructor()               { return instructor; }
    public void setCourseName(String courseName) { this.courseName = courseName; }
    public void setInstructor(String instructor) { this.instructor = instructor; }

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
    private static final double rate = 150.0;

    OnlineCourse(String courseName, String instructor, int durationHours) {
        super(courseName, instructor);
        this.durationHours = durationHours;
    }

    // Getter & Setter
    public int getDurationHours()                { return durationHours; }
    public void setDurationHours(int durationHours) { this.durationHours = durationHours; }

    @Override
    public double calculateCourseFee() {
        return durationHours * rate;
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
    private static final double rate = 500.0;

    OfflineCourse(String courseName, String instructor, int totalDays) {
        super(courseName, instructor);
        this.totalDays = totalDays;
    }

    // Getter & Setter
    public int getTotalDays()              { return totalDays; }
    public void setTotalDays(int totalDays) { this.totalDays = totalDays; }

    @Override
    public double calculateCourseFee() {
        return totalDays *rate;
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
        sc.nextLine(); 

    
        System.out.println("Enter Offline Course Name:");
        String offlineCourseName = sc.nextLine();

        System.out.println("Enter Offline Course Instructor:");
        String offlineInstructor = sc.nextLine();

        System.out.println("Enter Offline Course Duration (in days):");
        int offlineTotalDays = sc.nextInt();


        Course c1 = new OnlineCourse(onlineCourseName, onlineInstructor, onlineDurationHours);
        Course c2 = new OfflineCourse(offlineCourseName, offlineInstructor, offlineTotalDays);

        System.out.println("\n=== Course 1 ===");
        System.out.println(c1);

        System.out.println("\n=== Course 2 ===");
        System.out.println(c2);



        sc.close();
    }
}