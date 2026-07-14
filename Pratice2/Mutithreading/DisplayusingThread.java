class MyThread2 extends Thread {
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println("Nunber:"+i);
        }
    }
}

public class DisplayusingThread {
    public static void main(String[] args) {
        MyThread2 t = new MyThread2();
        t.start();
    }
}
