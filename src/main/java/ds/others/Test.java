package ds.others;

import java.util.concurrent.*;

/**
 * Created by sumit.jha on 04/08/18.
 */
public class Test {

    static class MyCallable implements Callable<String> {
        private String string;

        public MyCallable(String string) {
            this.string = string;
        }

        @Override
        public String call() throws Exception {
            int random = (int) (Math.random() * 10);
            Thread.currentThread().sleep(random * 1000);
            return string;
        }
    }

    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        CompletionService<String> completionService = new ExecutorCompletionService<>(executor);

        for (int i = 0; i < 10; i++) {
            completionService.submit(new MyCallable("MyCallable - " + i));
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(completionService.take().get());
        }

        executor.shutdown();
    }
}
