class TaskA implements Runnable {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Task A: " + i);
        }
    }
}

class TaskB implements Runnable {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Task B: " + i);
        }
    }
}

public class TwoTaskThreads {
    public static void main(String[] args) {
        Thread t1 = new Thread(new TaskA());
        Thread t2 = new Thread(new TaskB());

        t1.start();
        t2.start();
    }
}