
class MyThread extends Thread {
    public void run(){
        System.out.println("Thread running "+Thread.currentThread().getName());
    }
}

public class CreateAThread {
public static void main(String[] args){
    MyThread t = new MyThread();
    t.start();
}
}
