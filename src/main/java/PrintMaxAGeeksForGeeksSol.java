/**
 * Created by sumit.jha on 22/06/18.
 */
public class PrintMaxAGeeksForGeeksSol {

    private static int solve(int N) {

        int[] dp = new int[N + 1];
        for (int i = 0; i <= 6; i++) {
            dp[i] = i;
        }

        for (int i = 7; i <= N; i++) {
            int ans = Integer.MIN_VALUE;
            for (int j = 1;  j<= i - 3; j++) {
                ans = Math.max(ans, (i - j - 1) * dp[j]);
            }
            dp[i] = ans;
        }
        return dp[N];
    }

    public static void main(String[] args) {
        System.out.println(solve(20));
    }
}
