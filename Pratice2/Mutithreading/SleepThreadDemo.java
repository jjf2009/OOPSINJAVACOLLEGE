class SleepThread1 extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Count: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class SleepThreadDemo {
    public static void main(String[] args) {
        SleepThread1 t = new SleepThread1();
        t.start();
    }
}