package test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/**
 * Created by sumit.jha on 30/07/18.
 */
public class SemaphoreDemo {

    static class Shared {
        public static int VALUE = 0;
    }

    static class Worker implements Runnable {

        private String name;
        private Semaphore semaphore;

        public Worker(String name, Semaphore semaphore) {
            this.name = name;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                System.out.println(name + " is trying to acquire lock...");
                semaphore.acquire();

                for (int i = 0; i < 5; i++) {
                    Thread.sleep(1000);
                    System.out.println(name + " is in critical section | value = " + Shared.VALUE);
                    if (name.equals("A")) {
                        Shared.VALUE++;
                    } else {
                        Shared.VALUE--;
                    }
                }

                countDownLatch.countDown();
                System.out.println(name + " released the lock.");
                semaphore.release();

            } catch (Exception e) {}
        }
    }


    static CountDownLatch countDownLatch = new CountDownLatch(2);
    public static void main(String[] args) throws Exception {
        Semaphore semaphore = new Semaphore(1);
        Thread t1 = new Thread(new Worker("A", semaphore));
        Thread t2 = new Thread(new Worker("B", semaphore));

        t1.start();
        t2.start();

        countDownLatch.await();

        System.out.println("Threads completed, count =  " + Shared.VALUE);
    }
}
