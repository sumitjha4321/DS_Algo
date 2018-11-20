package test;

/**
 * Created by sumit.jha on 20/07/18.
 */
public class ThreadDemo {

    private static ThreadLocal<Integer> holder = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 1;
        }
    };


    public static void main(String[] args) throws Exception {

        //System.out.println(holder.get());

        Thread thread = new Thread(){
            @Override
            public void run() {
                holder.set(100);

                System.out.println("thread holder = " + holder.get());
            }
        };

        Thread anotherThread = new Thread(){
            @Override
            public void run() {
                holder.set(200);

                System.out.println("another thread, holder = " + holder.get());
            }
        };

        thread.start();
        anotherThread.start();


        System.out.println("main thread = " + holder.get());


    }
}
