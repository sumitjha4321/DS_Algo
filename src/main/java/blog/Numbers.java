package blog;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Numbers {

    public static List<Integer> findNumbers(List<Integer> l, Predicate<Integer> p) {
        return l.stream()
                .filter(num -> p.test(num))
                .collect(Collectors.toList());
    }

    public static List<Integer> findNumbers(List<Integer> l, BiPredicate<Integer, Integer> p) {
//        List<Integer> newList = new ArrayList<>();
//        for (Integer i : l) {
//            if (p.test(i, i + 10)) {
//                newList.add(i);
//            }
//        }
//        return newList;

        return l.stream()
                .filter(integer -> p.test(1, 2))
                .collect(Collectors.toList());




    }



    public static void main(String[] args) {

        List<Integer> ints = Arrays.asList(1, 2, 3, 4, 5);
        findNumbers(ints, new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer % 2 == 0;
            }
        });

        findNumbers(ints, integer -> integer % 2 == 0);

    }


}
