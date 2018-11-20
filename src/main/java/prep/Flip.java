package prep;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Flip {
    static class Pair {
        int first, second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }


    public static boolean hotel(List<Integer> arrive, List<Integer> depart, int K) {
        int N = arrive.size();
        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(new Pair(arrive.get(i), 1));
            list.add(new Pair(depart.get(i), 0));
        }
        Collections.sort(list, (p1, p2) -> {
            if (p1.first < p2.first) return -1;
            else if (p1.first > p2.first) return 1;
            else {
                return p1.second <= p2.second ? -1 : 1;
            }
        });

        for (Pair pair : list) {
            if (pair.second == 1) {
                K--;
            } else {
                K++;
            }
            if (K < 0) {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        System.out.println(hotel(Arrays.asList(2, 5), Arrays.asList(5, 6), 1));

    }
}
