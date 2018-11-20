/**
 * Created by sumit.jha on 23/06/18.
 */
public class CountNDigits {
    private static int solve2(int N, int sum) {
        if (N <= 1) {
            if (sum >= 1 && sum <= 9) return 1;
            else return 0;
        }
        int ans = 0;
        for (int i = 0; i <= 9; i++) {
            ans += solve2(N-1, sum - i);
        }
        return ans;
    }
    private static void solve(int N, int sum) {
        int[][] dp = new int[N + 1][sum + 1];
        for (int i = 1; i <= Math.min(9, sum); i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= sum; j++) {
                int ans = 0;
                for (int k = 0; k <= 9; k++) {
                    if (j - k >= 0) {
                        ans += dp[i - 1][j-k];
                    }
                }
                dp[i][j] = ans;
            }
        }
        for (int i = 1; i <= N; i++) {
            System.out.print("i = " + i + ": ");
            for (int j = 1; j <= sum; j++) {
                System.out.print(dp[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        //System.out.println(solve2(2, 1));
        solve(8, 25);
    }
}
