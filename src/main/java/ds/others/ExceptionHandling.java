package ds.others;

import java.util.concurrent.*;

/**
 * Created by sumit.jha on 16/08/18.
 */
public class ExceptionHandling {


    public static void main(String[] args) throws InterruptedException {


        ExecutorService service = Executors.newFixedThreadPool(10);
        Future<Integer> result = service.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 1/0;

            }
        });

        try {
            System.out.println(result.get());
        } catch (ExecutionException exception){
            exception.printStackTrace();
            System.out.println(exception.getCause());
        }

        service.shutdown();
        service.awaitTermination(10, TimeUnit.SECONDS);


    }
}
