abstract class Exercise {
    String name;

    Exercise(String name) {
        this.name = name;
    }

    abstract double caloriesBurned(int minutes);

    double withBonus(int minutes) {
        double cal = caloriesBurned(minutes);
        // bonus if name starts with "S"
        if (name.startsWith("S")) {
            cal += 50;
        }
        return cal;
    }
}

class Running extends Exercise {
    Running() {
        super("Running");
    }

    double caloriesBurned(int minutes) {
        return minutes * 10; // 10 cal/min
    }
}

class Swimming extends Exercise {
    Swimming() {
        super("Swimming");
    }

    double caloriesBurned(int minutes) {
        return minutes * 12; // 12 cal/min
    }
}

public class FitnessTracker {
    static Exercise mostCalories(Exercise[] arr, int minutes) {
        Exercise max = arr[0];
        for (Exercise e : arr) {
            if (e.withBonus(minutes) > max.withBonus(minutes)) {
                max = e;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Exercise[] list = {
            new Running(),
            new Swimming()
        };

        int minutes = 30;
        double total = 0;
        System.out.println("--- Calories for " + minutes + " min ---");
        for (Exercise e : list) {
            double c = e.withBonus(minutes);
            total += c;
            System.out.println(e.name + " : " + c);
        }
        System.out.println("Total calories: " + total);

        Exercise top = mostCalories(list, 30);
        System.out.println("Best for 30 min: " + top.name);
    }
}
