/**
 * Created by sumit.jha on 24/06/18.
 */
public class MobileNumericKeypad {

    private static void solve(int N) {
        int[][] dp = new int[N + 1][10];
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                switch (j) {
                    case 0:
                        dp[i][j] = dp[i - 1][0] + dp[i - 1][8];
                        break;
                    case 1:
                        dp[i][j] = dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][4];
                        break;
                    case 2:
                        dp[i][j] = dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3] + dp[i - 1][5];
                        break;
                    case 3:
                        dp[i][j] = dp[i - 1][3] + dp[i - 1][2] + dp[i - 1][6];
                        break;
                    case 4:
                        dp[i][j] = dp[i - 1][1] + dp[i - 1][4] + dp[i - 1][5] + dp[i - 1][7];
                        break;
                    case 5:
                        dp[i][j] = dp[i - 1][2] + dp[i - 1][4] + dp[i - 1][5] + dp[i - 1][6] + dp[i - 1][8];
                        break;
                    case 6:
                        dp[i][j] = dp[i - 1][3] + dp[i - 1][5] + dp[i - 1][6] + dp[i - 1][9];
                        break;
                    case 7:
                        dp[i][j] = dp[i - 1][4] + dp[i - 1][8] + dp[i - 1][7];
                        break;
                    case 8:
                        dp[i][j] = dp[i - 1][5] + dp[i - 1][7] + dp[i - 1][8] + dp[i - 1][9] + dp[i - 1][0];
                        break;
                    case 9:
                        dp[i][j] = dp[i - 1][9] + dp[i - 1][8] + dp[i - 1][6];
                        break;

                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                System.out.print(dp[i][j] + "  ");
            }
            System.out.println();
        }


        int ans = 0;
        for (int i = 0; i < 10; i++) {
            ans += dp[N][i];
        }
        System.out.println(ans);


    }

    public static void main(String[] args) {
        solve(5);

    }
}
