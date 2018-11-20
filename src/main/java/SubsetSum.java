/**
 * Created by sumit.jha on 25/09/18.
 */


public class SubsetSum {


    public static void main(String[] args) {

        int[] arr = {1, 2, 3};
        int sum = 5;

        boolean[][] dp = new boolean[sum + 1][arr.length + 1];

        for (int i = 0; i <= arr.length; i++) dp[0][i] = true;

        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= arr.length; j++) {
                dp[i][j] = dp[i][j-1] || dp[i - arr[j - 1]][j-1];
            }
        }

        for (int i = 0; i <= sum; i++) {
            for (int j = 0; j <= arr.length; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println();
        }

    }
}
