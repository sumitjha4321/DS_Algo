package test;

import java.util.concurrent.*;

/**
 * Created by sumit.jha on 02/08/18.
 */
public class InterfaceDemo {
    interface First{
        default void greet(){
            System.out.println("first");
        }
    }
    interface Second{
        void greet();
    }
    static class A implements First, Second{

        @Override
        public void greet() {
            System.out.println("overided");

        }
    }


    public static void main(String[] args) {

        RunnableFuture future = new RunnableFuture() {
            @Override
            public void run() {

            }

            @Override
            public boolean cancel(boolean mayInterruptIfRunning) {
                return false;
            }

            @Override
            public boolean isCancelled() {
                return false;
            }

            @Override
            public boolean isDone() {
                return false;
            }

            @Override
            public Object get() throws InterruptedException, ExecutionException {
                return null;
            }

            @Override
            public Object get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
                return null;
            }
        };



    }

}
