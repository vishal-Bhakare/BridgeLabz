package Multithreding;

public class ThreadExample {
    public static void main(String[] args) throws InterruptedException {
        Runnable task =() ->{
            for (int i=0;i<5;i++){
                System.out.println(i);

// System.out.println("Thread is running "+Thread.currentThread().getName());
            }
        };

        Runnable task1 =() ->{
            for (char i='a';i<'e';i++){
//System.out.println("Thread is running "+Thread.currentThread().getName());
                System.out.println(i);
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task1);
        t1.start();
        t1.join();
        t2.start();
    }
}
