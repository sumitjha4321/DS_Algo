package prep;

/**
 * Created by sumit.jha on 09/10/18.
 */
public class Sol {


    public static int solve(String str, int low, int high, int cost) {
        if (low == high) {
            return cost;
        }
        if (high - low == 1) {
            if (str.charAt(low) == str.charAt(high)) {
                return cost;
            } else {
                return cost + 1;
            }
        }


        if (str.charAt(low) == str.charAt(high)) {
            return Math.min(solve(str, low + 1, high - 1, cost), solve(str, low, high - 1, cost + 1));
        } else {
            return solve(str, low, high - 1, cost + 1);
        }

    }


    public static void main(String[] args) {
        String[] arr = {"abdc", "ab", "abdc"};

        System.out.println(solve("ABCA", 0, 3, 0));

    }
}
