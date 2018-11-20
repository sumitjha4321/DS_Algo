package test;

import java.util.concurrent.CountDownLatch;

/**
 * Created by sumit.jha on 30/07/18.
 */
public class TimerTask {
    public static void main(String[] args) throws Exception {
        int num = 5;
        CountDownLatch startLatch = new CountDownLatch(1);
        CountDownLatch endLatch = new CountDownLatch(num);

        for (int i = 0; i < num; i++) {
            new Thread() {
                @Override
                public void run() {
                    try {
                        startLatch.await();
                        Thread.sleep(1000);
                        endLatch.countDown();
                    } catch (InterruptedException e) {
                    }
                }
            }.start();
        }
        Long startTime = System.currentTimeMillis();
        startLatch.countDown();
        endLatch.await();
        System.out.println(System.currentTimeMillis()-startTime);
    }
}
