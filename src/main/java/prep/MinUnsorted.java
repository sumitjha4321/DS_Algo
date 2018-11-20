package prep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sumit.jha on 04/10/18.
 */
public class MinUnsorted {

    public static ArrayList<Integer> subUnsort(List<Integer> A) {
        int N = A.size();
        int low = -1, high = -1;
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < N - 1; i++) {
            if (A.get(i) > A.get(i + 1)) {
                low = i;
                break;
            }
        }
        if (low == -1) {
            result.add(-1);
            return result;
        }

        for (int i = N - 1; i > 0; i--) {
            if (A.get(i) < A.get(i - 1)) {
                high = i;
                break;
            }
        }
        if (high == -1) {
            result.add(-1);
            return result;
        }
        if (low > high) {
            int temp = low;
            low = high;
            high = temp;
        }
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int tmin = Integer.MAX_VALUE, tmax = Integer.MIN_VALUE;

        for (int i = low; i <= high; i++) {
            tmin = Math.min(tmin, A.get(i));
            tmax = Math.max(tmax, A.get(i));
        }

        for (int i = low-1; i>=0; i--){
            if (A.get(i) <= tmin){
                result.add(i+1);
                break;
            }
        }
        if (result.isEmpty()) result.add(0);

        for (int i = high+1; i<N; i++){
            if (A.get(i) >= tmax){
                result.add(i-1);
                break;
            }
        }
        if (result.size()==1) result.add(N-1);
        return result;



        /*
        while (true) {
            for (int i = low; i <= high; i++) {
                tmin = Math.min(tmin, A.get(i));
                tmax = Math.max(tmax, A.get(i));
            }
            if (min <= tmin && max >= tmax) {
                break;
            }
            min = tmin;
            max = tmax;
            for (int i = low - 1; i >= 0; i--) {
                if (A.get(i) <= min) {
                    break;
                }
                low--;
            }
            for (int i = high + 1; i < N; i++) {
                if (A.get(i) >= max) {
                    break;
                }
                high++;
            }
        }

        result.add(low);
        result.add(high);
        return result;
        */
    }


    public static void main(String[] args) {

        System.out.println(subUnsort(Arrays.asList(1, 3, 3, 5, 7, 9, 11, 11, 9, 7, 9, 11, 16, 17, 20, 20)));
        //System.out.println(subUnsort(Arrays.asList(1, 1, 10, 10, 15, 10, 15, 10, 10, 15, 10, 15)));


    }
}
