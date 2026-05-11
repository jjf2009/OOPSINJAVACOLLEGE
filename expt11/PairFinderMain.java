import java.util.Scanner;
import java.util.Vector;

class PairFinder {
    private Vector<Integer> numbers = new Vector<>();

    // Default constructor
    public PairFinder() {}

    public void add(int n) { 
        numbers.add(n); 
    }

    // Finds unique pairs (i, j) where i < j that sum to target
    public void findPairs(int target) {
        System.out.printf("Pairs for sum %d:%n", target);
        boolean found = false;
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                if (numbers.get(i) + numbers.get(j) == target) {
                    System.out.printf("(Index %d: %d, Index %d: %d)%n", 
                        i, numbers.get(i), j, numbers.get(j));
                    found = true;
                }
            }
        }
        if (!found) System.out.println("No such pairs found.");
    }

    // Displays details in a user friendly format
    @Override
    public String toString() {
        return "Vector Elements: " + numbers.toString();
    }
}

public class PairFinderMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PairFinder finder = new PairFinder();

        // All objects created through user input
        System.out.print("Enter number of integers to add to Vector: ");
        int n = sc.nextInt();

        System.out.println("Enter the integers:");
        for (int i = 0; i < n; i++) {
            finder.add(sc.nextInt());
        }

        System.out.println("\n" + finder.toString());

        System.out.print("Enter the target sum: ");
        int target = sc.nextInt();

        finder.findPairs(target);

        sc.close();
    }
}