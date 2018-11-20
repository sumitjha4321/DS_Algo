/**
 * Created by sumit.jha on 20/06/18.
 */
public class Knapsack {


    static void knapsack(int[] weights, int[] values, int W, int N) {
        int[][] dp = new int[W + 1][N + 1];
        for (int wt = 0; wt <= W; wt++) {
            for (int item = 0; item <= N; item++) {
                if (wt == 0 || item == 0) {
                    dp[wt][item] = 0;
                    continue;
                }
                if (wt >= weights[item - 1]) {
                    dp[wt][item] = Math.max(dp[wt - weights[item - 1]][item] + values[item - 1], dp[wt][item - 1]);
                } else {
                    dp[wt][item] = dp[wt][item - 1];
                }
            }
        }
        for (int i = 0; i <= W; i++) {
            for (int j = 0; j <= N; j++) {
                System.out.print(dp[i][j] + "    ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        int val[] = {1, 5, 8, 9, 10, 17, 17, 20};
        int wt[] = {1, 2, 3, 4, 5 , 6, 7, 8};
        int N = wt.length;
        int W = 8;
        knapsack(wt, val, W, N);

    }


}
