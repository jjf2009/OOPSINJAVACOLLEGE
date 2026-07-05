import java.time.LocalTime;

class TimePrinter extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Current Time: " + LocalTime.now());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class TimePrinterThread {
    public static void main(String[] args) {
        TimePrinter t = new TimePrinter();
        t.start();
    }
}