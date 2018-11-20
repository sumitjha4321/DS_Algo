package prep.algo;

/**
 * Created by sumit.jha on 18/10/18.
 */
public class CountNDigitWhoseSum {

    private static int solve(int sum, int n) {
        if (n == 1) {
            if (sum >= 1 && sum <= 9) return 1;
            return 0;
        }
        if (sum < 0) return 0;
        int ans = 0;
        for (int i = 0; i <= 9; i++) {
            ans += solve(sum - i, n - 1);
        }


        return ans;

    }

    public static void main(String[] args) {

        System.out.println(solve(6, 3));

    }
}
