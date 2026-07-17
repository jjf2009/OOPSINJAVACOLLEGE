abstract class MedicalStaff {
    String name;

    MedicalStaff(String name) {
        this.name = name;
    }

    abstract String getDepartment();
}

class Doctor extends MedicalStaff {
    Doctor(String name) {
        super(name);
    }

    String getDepartment() {
        return "Cardiology";
    }
}

class Nurse extends MedicalStaff {
    Nurse(String name) {
        super(name);
    }

    String getDepartment() {
        return "General Ward";
    }
}

public class HospitalPatientTracker {
    static String[] patients = new String[10];
    static int count = 0;

    static void admit(String name) {
        name = name.trim();
        // check duplicates
        for (int i = 0; i < count; i++) {
            if (patients[i].equalsIgnoreCase(name)) {
                System.out.println(name + " already admitted");
                return;
            }
        }
        if (count < patients.length) {
            patients[count++] = name;
            System.out.println("Admitted: " + name);
        } else {
            System.out.println("Hospital full");
        }
    }

    static void discharge(String name) {
        for (int i = 0; i < count; i++) {
            if (patients[i].equalsIgnoreCase(name)) {
                // shift left
                for (int j = i; j < count - 1; j++) {
                    patients[j] = patients[j + 1];
                }
                patients[--count] = null;
                System.out.println("Discharged: " + name);
                return;
            }
        }
        System.out.println(name + " not found");
    }

    static void displayPatients() {
        System.out.println("--- Current Patients ---");
        for (int i = 0; i < count; i++) {
            // format name
            String n = patients[i].toUpperCase();
            System.out.println((i + 1) + ". " + n);
        }
    }

    public static void main(String[] args) {
        MedicalStaff[] staff = {
            new Doctor("Dr Mehta"),
            new Nurse("Sister Ann")
        };

        System.out.println("--- Staff ---");
        for (MedicalStaff m : staff) {
            System.out.println(m.name + " - " + m.getDepartment());
        }

        admit("  ravi  ");
        admit("Priya");
        admit("Ravi"); // duplicate
        admit("Sohan");
        displayPatients();
        discharge("Priya");
        displayPatients();
    }
}
