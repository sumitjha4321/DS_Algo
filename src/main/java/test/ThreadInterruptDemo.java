package test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by sumit.jha on 31/07/18.
 */
public class ThreadInterruptDemo {

    private static Runnable getWorker() {
        return () -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().isInterrupted());
                }
                System.out.println(i);
                System.out.println(Thread.currentThread().isInterrupted());


            }
        };
    }

    public static void main(String[] args) throws Exception {


        Thread worker = new Thread(getWorker());
        worker.start();

        Thread.sleep(3000);

        worker.interrupt();
    }
}
