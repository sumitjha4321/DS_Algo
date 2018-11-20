package prep.algo;

/**
 * Created by sumit.jha on 16/10/18.
 */
public class MCM {

    static int solve(int[] p, int start, int end) {
        if (start == end) return 0;
        int ans = Integer.MAX_VALUE;
        for (int k = start; k < end; k++) {
            int left = solve(p, start, k);
            int right = solve(p, k + 1, end);
            ans = Math.min(ans, left + right + p[start] * p[k + 1] * p[end + 1]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] p = {40, 20, 30, 10, 30};
        int ans = solve(p, 0, p.length - 2);
        System.out.println(ans);
    }
}
