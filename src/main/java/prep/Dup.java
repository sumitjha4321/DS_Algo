package prep;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Math.abs;

/**
 * Created by sumit.jha on 05/10/18.
 */
public class Dup {

    public int repeatedNumber(final List<Integer> a) {

        Integer[] arr = new Integer[a.size()];
        arr = a.toArray(arr);

        for (int i = 0; i < arr.length; i++)
        {
            if (arr[abs(arr[i])] >= 0)
                arr[abs(arr[i])] = -arr[abs(arr[i])];
            else
                return abs(arr[i]);
        }
        return -1;

    }

    public static void main(String[] args) {

    }
}
