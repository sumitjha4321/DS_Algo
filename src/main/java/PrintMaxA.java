import java.util.List;

/**
 * Created by sumit.jha on 22/06/18.
 */
public class PrintMaxA {

    private static int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    private static int solve(int N, int res, int prev, int bufSize) {

        if (N == 0) {
            return res;
        }
        if (N < 0) {
            if (prev == 0) return res - 1;
            if (prev == 1) return res - bufSize;
            if (prev == 2) return res / 2;
        }
        if (prev != 0) {
            // prev was either scp, or  p
            return max(
                    solve(N - 1, res + 1, 0, bufSize), // print a
                    solve(N - 1, res + bufSize, 1, bufSize), // just p
                    solve(N - 3, 2 * res, 2, res) // scp
            );
        } else {
            return Math.max(solve(N - 1, res + 1, 0, bufSize), solve(N - 3, 2 * res, 2, res));
        }
    }

    public static void main(String[] args) {
        System.out.println(solve(19, 0, 0, 0));
    }
}
