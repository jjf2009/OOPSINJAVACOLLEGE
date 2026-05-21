class MyThread extends Thread {

    public MyThread(String name) {
        super(name); // sets thread name
    }

    public void run() {

        for (int i = 1; i <= 4; i++) {

            System.out.println(
                Thread.currentThread().getName() + " : " + i
            );

            try {
                Thread.sleep(500); // pause for 500 milliseconds
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class ThreadCount {

    public static void main(String[] args) {

        MyThread t1 = new MyThread("Thread-A");
        MyThread t2 = new MyThread("Thread-B");
        MyThread t3 = new MyThread("Thread-C");

        t1.start();
        t2.start();
        t3.start();
    }
}