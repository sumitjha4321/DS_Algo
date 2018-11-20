/**
 * Created by sumit.jha on 21/06/18.
 */
public class WaysToReachScore {
    /*private static int solve(int n) {
        if (n == 3 || n == 5 || n == 10) return 1;
        if (n < 3) return 0;
        return solve(n - 3) + solve(n - 5) + solve(n - 10);
    }*/

    private static int[] coins = {0, 3, 5, 10};


    private static void solve(int N) {
        int[][] dp = new int[N + 1][4];
        for (int i = 0; i <= 3; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= 3; j++) {
                if (i >= coins[j]) {
                    dp[i][j] = dp[i - coins[j]][j] + dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        for (int i = 0; i <= N; i++) {
            System.out.print("i = " + i + ":  ");
            for (int j = 0; j <= 3; j++) {
                System.out.print(dp[i][j] + "  ");
            }
            System.out.println();
        }

    }

    private static void solve2(){

    }


    public static void main(String[] args) {
        solve(20);

    }
}
