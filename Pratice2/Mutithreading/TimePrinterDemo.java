
import java.time.LocalTime;

class PrintTime extends Thread {
         public void run(){
            System.out.println("Local Time:"+LocalTime.now());
         }
}

public class TimePrinterDemo {
    public static void main(String[] args) {
        PrintTime  t = new PrintTime();
        t.start();
    }
}
