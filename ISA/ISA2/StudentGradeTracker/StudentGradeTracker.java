abstract class Student {
    String name;
    double marks;

    Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    abstract double computeGrade();
}

class UndergraduateStudent extends Student {
    UndergraduateStudent(String name, double marks) {
        super(name, marks);
    }

    double computeGrade() {
        return marks; // direct marks as grade
    }
}

class GraduateStudent extends Student {
    GraduateStudent(String name, double marks) {
        super(name, marks);
    }

    double computeGrade() {
        return marks * 0.9 + 10; // slight curve
    }
}

public class StudentGradeTracker {
    static int countPassed(Student[] arr) {
        int c = 0;
        for (Student s : arr) {
            if (s.computeGrade() >= 50) c++;
        }
        return c;
    }

    public static void main(String[] args) {
        Student[] students = {
            new UndergraduateStudent("Alice", 75),
            new GraduateStudent("Kumar", 60),
            new UndergraduateStudent("Bob", 40),
            new GraduateStudent("Kiran", 55)
        };

        System.out.println("--- Grades ---");
        for (Student s : students) {
            System.out.println(s.name + " : " + s.computeGrade());
            // greeting if name contains "K"
            if (s.name.contains("K")) {
                System.out.println("  Hello " + s.name + "!");
            }
        }

        System.out.println("Passed (grade >= 50): " + countPassed(students));
    }
}
