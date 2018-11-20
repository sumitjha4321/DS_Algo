package ds.others;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by sumit.jha on 14/08/18.
 */
public class TaskCancellation {

    static class PrimeGenerator implements Runnable {

        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(1);

        @Override
        public void run() {

            for (int i = 0; i < 5; i++) {
                try {
                    queue.put(i);
                    System.out.println(i + " inserted to queue..");
                } catch (InterruptedException e) {
                    System.out.println("I am interrupted..exiting the loop");
                    break;
                }
            }
        }
    }

    static void hi () {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) throws Exception {



        hi();
        if (Thread.currentThread().isInterrupted()){
            System.out.println("jheyyy");
        }
        //Thread.currentThread().interrupt();




    }

}
