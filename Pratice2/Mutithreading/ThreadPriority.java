class PriorityThread extends Thread {
    public PriorityThread(String name){
        super(name);
    }
     public void run(){
        System.out.println("Thread is running"+Thread.currentThread().getName()+"Prioriyt: "+Thread.currentThread().getPriority());
     }
}

public class ThreadPriority {
    public static void main(String[] args) {
        PriorityThread t1 =  new PriorityThread("HIGH");
        PriorityThread t2 = new PriorityThread("LOW");

        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);

        t2.start();
        t1.start();
    }
    
}
