class TaskThread extends Thread {
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println("Task completed.");
    }
}

public class ThreadAliveCheck {
    public static void main(String[] args) throws InterruptedException {
        TaskThread t = new TaskThread();

        System.out.println("Before start, alive: " + t.isAlive());
        t.start();
        System.out.println("After start, alive: " + t.isAlive());

        t.join();
        System.out.println("After completion, alive: " + t.isAlive());
    }
}