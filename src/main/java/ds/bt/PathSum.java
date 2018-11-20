package ds.bt;

// Java code to find
// the OR_SUM
import java.io.*;

class GFG {

    static int INT_SIZE = 32;

    // function to find
    // the OR_SUM
    static int ORsum(int []arr, int n)
    {

        // create an array of size 32
        // and store the sum of bits
        // with value 0 at every index.
        int zerocnt[] = new int[INT_SIZE] ;

        for (int i = 0; i < INT_SIZE; i++)
            for (int j = 0; j < n; j++)
                if ((arr[j] & 1 << i) == 0)
                    zerocnt[i] += 1;

        // for each index the OR
        // sum contributed by that
        // bit of subset will be
        // 2^(bit index) now the OR
        // of the bits is 0 only if
        // all the ith bit of the
        // elements in subset is 0.
        int ans = 0;
        for (int i = 0; i < INT_SIZE; i++)
        {
            ans += ((Math.pow(2, n) - 1) -
                    (Math.pow(2, zerocnt[i]) - 1)) *
                    Math.pow(2, i);
        }

        return ans;

    }
    // Driver Code
    public static void main(String[] args)
    {
        int arr[] = { 1, 2, 3 };
        int size = arr.length;
        System.out.println(ORsum(arr, size));

    }
}

// This code is contributed by Sam007