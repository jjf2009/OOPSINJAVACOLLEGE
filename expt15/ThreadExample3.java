class Buffer {

    int data;
    boolean available = false;

    synchronized void produce(int value) {

        while (available) {

            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

        data = value;
        available = true;

        System.out.println("Produced: " + data);

        notify();
    }

    synchronized void consume() {

        while (!available) {

            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

        System.out.println("Consumed: " + data);

        available = false;

        notify();
    }
}

class Producer extends Thread {

    Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {

        for (int i = 1; i <= 5; i++) {

            buffer.produce(i);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class Consumer extends Thread {

    Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {

        for (int i = 1; i <= 5; i++) {

            buffer.consume();

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class ThreadExample3 {

    public static void main(String[] args) {

        Buffer buffer = new Buffer();

        Producer p = new Producer(buffer);
        Consumer c = new Consumer(buffer);

        p.start();
        c.start();
    }
}