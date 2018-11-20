package test;

import java.util.concurrent.CountDownLatch;

/**
 * Created by sumit.jha on 28/07/18.
 */
public class Temp {

    public static void main(String[] args) throws Exception{
        CountDownLatch countDownLatch = new CountDownLatch(4);

        Thread t1 = new Thread(new Worker("A", 100, countDownLatch));
        Thread t2 = new Thread(new Worker("B", 200, countDownLatch));
        Thread t3 = new Thread(new Worker("C", 300, countDownLatch));
        Thread t4 = new Thread(new Worker("D", 60, countDownLatch));

        t1.start();
        t2.start();
        t3.start();
        t4.start();


        System.out.println("main thread "  + Thread.currentThread().getId() + " has finished");



    }

    static class Worker implements Runnable {
        int delay = 0;
        CountDownLatch latch;
        String name;

        public Worker(String name, int delay, CountDownLatch latch){
            this.name = name;
            this.delay = delay;
            this.latch = latch;
        }
        @Override
        public void run() {

            try {
                latch.await();

                Thread.sleep(delay);
                System.out.println("worker thread "  + name + " has finished");
                latch.countDown();


            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }
}
