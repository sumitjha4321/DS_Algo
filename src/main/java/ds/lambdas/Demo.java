package ds.lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sumit.jha on 05/08/18.
 */
public class Demo {

    public static void printMessage() {
        System.out.println("Hello there");
    }

    public static void main(String[] args) {

        Thread t = new Thread(Demo::printMessage);

        Thread anotherThread = new Thread(new Runnable() {
            @Override
            public void run() {
                printMessage();
            }
        });
        t.start();

        List<Integer> list = new ArrayList<>();
        list.stream()
                .filter(element -> element % 2 == 1)
                .map(element -> element.byteValue())
                .collect(Collectors.toList());


    }
}
