package prep;

import java.util.*;

/**
 * Created by sumit.jha on 04/10/18.
 */
public class MaxDistance {

    static class Pair {
        int idx;
        int val;

        public Pair(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }

    public static int maximumGap(final List<Integer> A) {
        int N = A.size();
        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            list.add(new Pair(i, A.get(i)));
        }
        Collections.sort(list, (p1, p2) -> {
            if (p1.val < p2.val) return -1;
            else if (p1.val > p2.val) return 1;
            else {
                return p1.idx <= p2.idx ? -1 : 1;
            }
        });
        int[] max = new int[N];
        Arrays.fill(max, Integer.MIN_VALUE);
        max[N - 1] = list.get(N - 1).idx;
        for (int i = N - 2; i >= 0; i--) {
            max[i] = Math.max(max[i + 1], list.get(i).idx);

        }
        /*Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            map.put(list.get(i).val, list.get(i).idx);
        }
        */

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < N - 1; i++) {
            ans = Math.max(ans, max[i+1] - list.get(i).idx);
        }
        return ans <=0 ? -1 : ans;
    }


    public static void main(String[] args) {
        System.out.println(maximumGap(Arrays.asList(3, 4, 1)));
    }
}
