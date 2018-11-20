/**
 * Created by sumit.jha on 21/06/18.
 */
public class MinSquare {

    private static void solve(int N) {
        int sqrtN = (int) Math.floor(Math.sqrt(N));
        int[][] dp = new int[N + 1][sqrtN + 1];

        for (int i = 1; i <= N; i++) {
            dp[i][1] = i;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 2; j <= sqrtN; j++) {
                if (i >= j * j) {
                    dp[i][j] = Math.min(dp[i - j * j][j]+1, dp[i][j-1]);
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        for (int i = 0; i <= N; i++) {
            System.out.print("i = " + i + ":    ");
            for (int j = 0; j <= sqrtN; j++) {
                System.out.print(dp[i][j] + "  ");
            }
            System.out.println();
        }


    }


    public static void main(String[] args) {
        solve(9891);
    }
}
