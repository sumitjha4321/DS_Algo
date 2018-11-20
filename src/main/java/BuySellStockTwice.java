/**
 * Created by sumit.jha on 25/06/18.
 */
public class BuySellStockTwice {

    public static void main(String[] args) {
        int n = 7;

        int[] P = {10, 22, 5, 75, 65, 80};
        int[] R = new int[n];
        int[] L = new int[n];

        int m = P[n - 1];

        for (int i = n - 2; i >= 0; i--) {

            m = Math.max(m, P[i]);

            R[i] = Math.max(R[i + 1], m - P[i]);
        }

        m = P[0];

        for (int i = 1; i < n; i++) {

            m = Math.min(m, P[i]);

            L[i] = Math.max(L[i - 1], P[i] - m);
        }

        int ans = L[0] + R[0];

        for (int i = 1; i < n; i++) {

            ans = Math.max(ans, L[i] + R[i]);
        }

        System.out.println("Left");
        for (int i = 0; i < n; i++) {

            System.out.print(L[i] + "  ");
        }
        System.out.println();

        System.out.println("Right");
        for (int i = 0; i < n; i++) {

            System.out.print(R[i] + "  ");
        }
        System.out.println();

    }

}
