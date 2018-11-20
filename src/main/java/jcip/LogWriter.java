package jcip;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by sumit.jha on 26/08/18.
 */
public class LogWriter {

    public static <T> void test (List<T> list){

        Collection<T> collection = list;
        list.get(0);

    }

    public static void main(String[] args) throws InterruptedException {




        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(1);

        Thread t = new Thread(new Runnable(){
            @Override
            public void run() {

                try {
                    System.out.println("first put...");
                    queue.put("hola");
                    System.out.println("second put...");
                    queue.put("bahar se vola");
                } catch (InterruptedException e){
                    e.printStackTrace();
                } finally {
                    System.out.println("done putting");
                }
            }
        });

        t.start();

        Thread.sleep(3000);



        System.out.println("Interrupting thread now");
        t.interrupt();


    }
}
