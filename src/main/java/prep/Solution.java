package prep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static int searchInsert(List<Integer> a, int K) {

        int[] arr = new int[a.size()];
        for (int i = 0; i < a.size(); i++) {
            arr[i] = a.get(i);
        }

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= K) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static int pow(int x, int y, int MOD) {
        long res = 1;
        boolean neg = false;
        if (x < 0) {
            if (y % 2 == 1) {
                neg = true;
            }
            x = -x;
        }

        while (y > 0) {
            if ((y & 1) != 0) {
                res = (1L * res * x) % MOD;
            }
            x = (int) ((1L * x * x) % MOD);
            y = y >> 1;
        }
        if (neg) {
            res = -res;
            while (res < 0) {
                res += MOD;
            }
        }
        return (int) (res % MOD);
    }

    public static void main(String[] args) {

        System.out.println(pow(71045970, 41535484, 64735492));

    }
}
