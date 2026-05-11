import java.util.Scanner;
import java.util.Stack;

class StackSorter {
    private Stack<Integer> originalStack = new Stack<>();

    // Default constructor [cite: 4, 56]
    public StackSorter() {}

    public void addElement(int val) {
        originalStack.push(val);
    }

    public void sort() {
        Stack<Integer> tempStack = new Stack<>();
        while (!originalStack.isEmpty()) {
            int current = originalStack.pop();
            while (!tempStack.isEmpty() && tempStack.peek() > current) {
                originalStack.push(tempStack.pop());
            }
            tempStack.push(current);
        }
        originalStack = tempStack;
    }

    // Displays details in a user friendly format [cite: 5, 57]
    @Override
    public String toString() {
        return "Sorted Stack (Smallest on top): " + originalStack;
    }
}

public class StackSorterMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StackSorter sorter = new StackSorter();

        // Objects created through user input [cite: 7, 59]
        System.out.print("Enter number of elements to push onto stack: ");
        int count = sc.nextInt();

        System.out.println("Enter the integers:");
        for (int i = 0; i < count; i++) {
            sorter.addElement(sc.nextInt());
        }

        System.out.println("Original " + sorter);
        sorter.sort();
        System.out.println(sorter);

        sc.close();
    }
}