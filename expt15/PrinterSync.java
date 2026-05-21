class Printer {

    synchronized void printDocument(String userName) {

        System.out.println(userName + " started printing");

        for (int i = 1; i <= 2; i++) {

            System.out.println(userName + " : Printing line " + i);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

        System.out.println(userName + " finished printing");
        System.out.println();
    }
}

class UserThread extends Thread {

    Printer printer;

    public UserThread(Printer printer, String name) {
        super(name);
        this.printer = printer;
    }

    public void run() {
        printer.printDocument(getName());
    }
}

public class PrinterSync {

    public static void main(String[] args) {

        Printer sharedPrinter = new Printer();

        UserThread t1 = new UserThread(sharedPrinter, "Alice");
        UserThread t2 = new UserThread(sharedPrinter, "Bob");
        UserThread t3 = new UserThread(sharedPrinter, "Charlie");

        t1.start();
        t2.start();
        t3.start();
    }
}