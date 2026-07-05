interface Printable {
    void print();
}

class Student implements Printable {
    private int rollNo;
    private String name;
    private String course;

    public Student(int rollNo, String name, String course) {
        this.rollNo = rollNo;
        this.name = name;
        this.course = course;
    }

    @Override
    public void print() {
        System.out.println("Student Details");
        System.out.println("Roll No : " + rollNo);
        System.out.println("Name    : " + name);
        System.out.println("Course  : " + course);
    }
}

public class PrintableStudent {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);

        System.out.print("Enter roll number: ");
        int rollNo = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter course: ");
        String course = sc.nextLine();

        Printable student = new Student(rollNo, name, course);
        student.print();

        sc.close();
    }
}