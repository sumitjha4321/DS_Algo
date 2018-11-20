package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class Java82 {

    public static List<Integer> test(List<Integer> list, Predicate<Integer> predicate) {
        List<Integer> newList = new ArrayList<>();

        for (int num : list) {
            if (predicate.test(num)) {
                newList.add(num);
            }
        }
        return newList;
    }

    public static void main(String[] args) {
    }


}
