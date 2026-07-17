abstract class Person {
    String name;

    Person(String name) {
        this.name = name;
    }

    abstract String getRole();
}

class Student extends Person {
    int m1, m2, m3;

    Student(String name, int m1, int m2, int m3) {
        super(name);
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
    }

    String getRole() {
        return "Student";
    }

    double average() {
        return (m1 + m2 + m3) / 3.0;
    }

    char grade() {
        double avg = average();
        if (avg >= 90) return 'A';
        else if (avg >= 75) return 'B';
        else if (avg >= 50) return 'C';
        else return 'F';
    }

    int countVowels() {
        int c = 0;
        String n = name.toLowerCase();
        for (int i = 0; i < n.length(); i++) {
            char ch = n.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') c++;
        }
        return c;
    }

    String reverseName() {
        return new StringBuilder(name).reverse().toString();
    }

    void reportCard() {
        System.out.println(name + " | Avg: " + average() + " | Grade: " + grade()
                + " | Vowels: " + countVowels() + " | Reverse: " + reverseName());
    }
}

class Teacher extends Person {
    String subject;

    Teacher(String name, String subject) {
        super(name);
        this.subject = subject;
    }

    String getRole() {
        return "Teacher";
    }
}

public class StudentResultManagement {
    static Student searchByName(Student[] arr, String name) {
        for (Student s : arr) {
            if (s.name.equalsIgnoreCase(name)) return s;
        }
        return null;
    }

    public static void main(String[] args) {
        Student[] students = {
            new Student("Alice", 90, 85, 88),
            new Student("Bob", 60, 55, 70),
            new Student("Kiran", 40, 45, 50)
        };

        Person t = new Teacher("Mr Smith", "Maths");
        System.out.println(t.name + " is a " + t.getRole());

        System.out.println("--- Report Cards ---");
        for (Student s : students) {
            s.reportCard();
        }

        Student found = searchByName(students, "Bob");
        if (found != null) {
            System.out.println("Found: " + found.name + " grade " + found.grade());
        }
    }
}
