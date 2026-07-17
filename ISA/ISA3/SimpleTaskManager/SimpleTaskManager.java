import java.io.*;
import java.util.*;

class NoTasksException extends Exception {
    NoTasksException(String msg) {
        super(msg);
    }
}

interface Taskable {
    void addTask(String task);
    void completeTask() throws NoTasksException;
}

class TaskManager implements Taskable {
    LinkedList<String> tasks = new LinkedList<>();

    public void addTask(String task) {
        tasks.add(task);
        System.out.println("Added: " + task);
    }

    public void completeTask() throws NoTasksException {
        if (tasks.isEmpty()) {
            throw new NoTasksException("No tasks to complete");
        }
        String done = tasks.removeFirst(); // remove from front
        System.out.println("Completed: " + done);
    }

    void savePending() throws IOException {
        FileWriter fw = new FileWriter("tasks.txt");
        for (String t : tasks) {
            fw.write(t + "\n");
        }
        fw.close();
        System.out.println("Pending tasks saved to tasks.txt");
    }
}

public class SimpleTaskManager {
    public static void main(String[] args) {
        TaskManager tm = new TaskManager();
        try {
            tm.addTask("Study Java");
            tm.addTask("Write code");
            tm.addTask("Submit lab");
            tm.completeTask();
            tm.savePending();

            tm.completeTask();
            tm.completeTask();
            tm.completeTask(); // empty
        } catch (NoTasksException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}
