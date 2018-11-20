package test;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Created by sumit.jha on 30/07/18.
 */
public class FutureDemo {
    static class Worker implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            Thread.sleep(3000);
            System.out.println("waked");
            return (int) (Math.random() * 100);
        }
    }

    public static void main(String[] args) throws Exception {

        FutureTask task = new FutureTask(new Worker());
        task.run();

        System.out.println("result of task is " + task.get());


    }
}
