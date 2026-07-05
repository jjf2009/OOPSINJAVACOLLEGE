class MessageThread extends Thread {
    private String message;

    public MessageThread(String message) {
        this.message = message;
    }

    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(message + " - " + i);
        }
    }
}

public class TwoMessageThreads {
    public static void main(String[] args) {
        MessageThread t1 = new MessageThread("Hello");
        MessageThread t2 = new MessageThread("Welcome");

        t1.start();
        t2.start();
    }
}