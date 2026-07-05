class MyTask implements Runnable {
    public void run() {
        System.out.println("Runnable task running: " + Thread.currentThread().getName());
    }
}

public class RunnableDemo {
    public static void main(String[] args) {
        Thread t = new Thread(new MyTask());
        t.start();
    }
}