/**
 * Created by sumit.jha on 25/06/18.
 */
public class LongestEvenLengthSubstrWithEqual {

    private static void solve(String str) {
        int N = str.length();
        int[][] dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            dp[i][i] = str.charAt(i) - '0';
        }

        int ans = 0;
        int startIdx = -1;
        int endIdx = -1;
        for (int L = 1; L < N; L++) {
            for (int i = 0; i < N - L; i++) {
                int j = i + L;
                int half = (i + j) / 2;
                dp[i][j] = dp[i][half] + dp[half + 1][j];
                if (L % 2 == 1) {
                    if (ans < dp[i][half] && dp[i][half] == dp[half + 1][j]) {
                        ans = dp[i][half];
                        startIdx = i;
                        endIdx = j;
                    }

                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(dp[i][j] + "  ");
            }
            System.out.println();
        }

        System.out.println(startIdx + "  " + endIdx);

    }

    private static void solve2(String str) {
        int N = str.length();
        int ans = 0;
        int l = -1, r = -1;
        for (int i = 0; i < N - 1; i++) {
            int lp = i;
            int hp = i+1;
            int lsum = 0, rsum = 0;
            while (hp < N && lp >= 0) {
                lsum += (str.charAt(lp) - '0');
                rsum += (str.charAt(hp) - '0');
                if (ans < lsum && lsum == rsum) {
                    ans = lsum;
                    l = lp;
                    r = hp;
                }
                lp--;
                hp++;
            }

        }
        System.out.println("l = " + l + " r = " + r);
    }

    public static void main(String[] args) {
        solve2("1538023");

    }
}
