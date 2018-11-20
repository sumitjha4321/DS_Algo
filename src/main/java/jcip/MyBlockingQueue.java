package jcip;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by sumit.jha on 25/08/18.
 */
public class MyBlockingQueue<E> extends ArrayBlockingQueue<E> {

    public MyBlockingQueue(int capacity) {
        super(capacity);
    }

    @Override
    public void put(E e) throws InterruptedException {
        System.out.println("");
        super.put(e);
    }
}
