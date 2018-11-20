package jcip;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by sumit.jha on 25/08/18.
 */
public class PrimeProducer extends Thread {

    @Override
    public void run() {
        System.out.println("Running on thread: " + Thread.currentThread().getId());
        try {
            Thread.currentThread().sleep(3000);
            throw new ArithmeticException("laude in native thread");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {

        System.out.println("Running on thread: " + Thread.currentThread().getId());
        //new PrimeProducer().start();

        ExecutorService service = Executors.newFixedThreadPool(5);
        service.submit(() -> {
            System.out.println("Running on thread: " + Thread.currentThread().getName());
            try {
                Thread.currentThread().sleep(1000);
                throw new ArithmeticException("laude in lambda");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

        service.shutdown();

    }
}
