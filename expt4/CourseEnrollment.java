class Course {
    private int courseId;
    private String courseName;
    private double fee;

    public Course(int courseId, String courseName, double fee) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.fee = fee;
    }

    public double getFee() {
        return fee;
    }

    public void display() {
        System.out.println("Course ID: " + courseId +
                ", Name: " + courseName +
                ", Fee: " + fee);
    }
}

public class CourseEnrollment {
    public static void main(String[] args) {

        java.util.Scanner scanner = new java.util.Scanner(System.in);
        
        System.out.print("Enter number of courses: ");
        int n = scanner.nextInt();
        
        Course[] courses = new Course[n];
        
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for course " + (i + 1) + ":");
            System.out.print("Course ID: ");
            int courseId = scanner.nextInt();
            scanner.nextLine(); 
            System.out.print("Course Name: ");
            String courseName = scanner.nextLine();
            System.out.print("Fee: ");
            double fee = scanner.nextDouble();
            
            courses[i] = new Course(courseId, courseName, fee);
        }
        
        scanner.close();
        System.out.println("\n--- Course Details ---");


        double totalFee = 0;

        for (Course c : courses) {
            c.display();
            totalFee += c.getFee();
        }

        System.out.println("Total Fees of All Courses: " + totalFee);
    }
}