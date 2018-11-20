package ds.others;

import java.util.Objects;
import java.util.StringJoiner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by sumit.jha on 06/08/18.
 */
public class WaitNotifyTest {


    static class Waiter implements Runnable {

        private Object object;

        public Waiter(Object object) {
            this.object = object;
        }

        @Override
        public void run() {

            synchronized (object) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("worker thread is about to notify");
                object.notify();
                System.out.println("worker thread notified");
            }
        }
    }

    private static int counter = 0;

    static class Glass<T> {
        Integer t;


    }

    public static void add (Glass<? > glass){




    }

    public static void main(String[] args) throws InterruptedException {

        add(new Glass<Object> ());

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        String[] strings = new String[1];
        Object[] objects = strings;
        objects[0] = 0;




        for (int i = 0; i < 25; i++) {
            executorService.submit(() -> {
                System.out.println("task " + (counter++) + " executed by thread: " + Thread.currentThread().getName());
            });
        }

        executorService.shutdown();

    }
}
