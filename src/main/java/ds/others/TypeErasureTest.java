package ds.others;

import java.util.*;

public class TypeErasureTest {

    public static double sum(List<? extends Number> numbers) {
        double sum = 0;
        for (Number number : numbers) {
            sum = sum + number.doubleValue();
        }
        return sum;
    }

    public static <T extends Number> void reverse(List<T> list) {
        List<T> temp = new ArrayList<>(list);
        for (int i = 0; i < list.size(); i++) {
            list.set(i, temp.get(list.size() - i - 1));
        }
    }

    public static void test(List<List<? extends Integer>> lists) {
        List<? extends Integer> list = lists.get(0);
        Integer i = list.get(0);


    }


    public static void main(String args[]) {

        List<List<?>> lists = new ArrayList<List<?>>();
        lists.add(Arrays.asList(1, 2));

    }

}