package ds.others;

import java.math.BigInteger;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;
import java.util.logging.Logger;

public class Dummy {

    static interface CancellableCallable<T> extends Callable<T> {
        void cancel();

        RunnableFuture<T> newTask();
    }

    static abstract class ConnectionUsingTask<T> implements CancellableCallable<T> {

        private Connection connection;

        @Override
        public void cancel() {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                /* ignored */
            }
        }

        @Override
        public RunnableFuture<T> newTask() {
            return new FutureTask<T>(this) {
                @Override
                public boolean cancel(boolean mayInterruptIfRunning) {
                    try {
                        ConnectionUsingTask.this.cancel();
                    } finally {
                        return super.cancel(mayInterruptIfRunning);
                    }
                }
            };
        }
    }

    public static void main(String[] args) throws Exception {

        /*ExecutorService service = new ThreadPoolExecutor(4, 4, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>()) {
            @Override
            protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
                System.out.println("callable submitted");
                return new FutureTask<T>(callable) {
                    @Override
                    public boolean cancel(boolean mayInterruptIfRunning) {

                        if (callable instanceof CancellableCallable) {
                            // close the inputstream as well
                        }
                        System.out.println("Cancelling task...");
                        return super.cancel(mayInterruptIfRunning);
                    }
                };
            }
        };*/


        ExecutorService service = new ThreadPoolExecutor(4, 4, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>()) {
            @Override
            protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
                if (callable instanceof CancellableCallable) {
                    return ((CancellableCallable<T>) callable).newTask();
                } else {
                    return super.newTaskFor(callable);
                }
            }
        };

        /*
        service.submit(() -> {
            System.out.println("Starting to sleep on thread: " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
                System.out.println("Done sleeping, exiting now");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        */

        Future<Void> future = service.submit(new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                System.out.println("Starting to sleep on thread: " + Thread.currentThread().getName());
                //Thread.sleep(5000);
                for (int i = 1; i < 1000; i++) {
                    System.out.println("printing " + i);
                }
                System.out.println("Done sleeping, exiting now");
                return null;
            }
        });

        //System.out.println("Main thread sleeping for 1 second");
        Thread.sleep(1);

        System.out.println("Starting to interrupt");
        future.cancel(true);


        /*service.submit(new CancellableCallable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return null;
            }

            @Override
            public void cancel() {

            }

        })

        */


        service.shutdown();

    }
}
