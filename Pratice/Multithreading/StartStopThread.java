class StoppableThread extends Thread {
    private volatile boolean running = true;

    public void stopThread() {
        running = false;
    }

    public void run() {
        int count = 1;
        while (running) {
            System.out.println("Running count: " + count++);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                break;
            }
        }
        System.out.println("Thread stopped.");
    }
}

public class StartStopThread {
    public static void main(String[] args) throws InterruptedException {
        StoppableThread t = new StoppableThread();
        t.start();

        Thread.sleep(3000);
        t.stopThread();
        t.join();
    }
}