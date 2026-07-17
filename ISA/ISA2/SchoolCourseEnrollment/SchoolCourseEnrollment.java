abstract class Course {
    String courseName;

    Course(String courseName) {
        this.courseName = courseName;
    }

    abstract String getCourseType();
}

class OnlineCourse extends Course {
    String[] students = new String[5];
    int count = 0;

    OnlineCourse(String courseName) {
        super(courseName);
    }

    String getCourseType() {
        return "Online Course";
    }

    void enroll(String name) {
        if (count >= 5) {
            System.out.println("Course Full");
            return;
        }
        students[count++] = name;
        System.out.println("Enrolled: " + name);
        if (count == 5) {
            System.out.println("Course Full");
        }
    }

    void listStudents() {
        System.out.println("--- Students ---");
        for (int i = 0; i < count; i++) {
            System.out.println(students[i].toLowerCase());
        }
    }

    void findStudent(String name) {
        for (int i = 0; i < count; i++) {
            if (students[i].equalsIgnoreCase(name)) {
                System.out.println(name + " is enrolled");
                return;
            }
        }
        System.out.println(name + " not found");
    }
}

public class SchoolCourseEnrollment {
    public static void main(String[] args) {
        OnlineCourse oc = new OnlineCourse("Java Programming");
        oc.enroll("Alice");
        oc.enroll("Bob");
        oc.enroll("Charlie");
        oc.enroll("Diana");
        oc.enroll("Eve");
        oc.enroll("Frank"); // full

        oc.listStudents();
        oc.findStudent("Bob");
        oc.findStudent("Zara");

        // polymorphism
        Course ref = oc;
        System.out.println(ref.courseName + " is " + ref.getCourseType());
    }
}
