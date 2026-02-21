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
        Course[] courses = {
                new Course(1, "Java Programming", 5000),
                new Course(2, "Data Structures", 6000),
                new Course(3, "Database Systems", 5500)
        };

        double totalFee = 0;

        for (Course c : courses) {
            c.display();
            totalFee += c.getFee();
        }

        System.out.println("Total Fees of All Courses: " + totalFee);
    }
}