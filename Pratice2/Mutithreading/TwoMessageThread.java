
class MyThread2 extends Thread {
    public void run(){
        System.out.println("Thread running2 "+Thread.currentThread().getName());
    }
}

class MyThread1 extends Thread {
    public void run(){
        System.out.println("Thread running1 "+Thread.currentThread().getName());
    }
}
public class TwoMessageThread {
public static void main(String[] args){
    MyThread1 t1 = new MyThread1();
    MyThread2 t2= new MyThread2();
    t1.start();
    t2.start();
}
}
