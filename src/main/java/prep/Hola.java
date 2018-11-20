package prep;

import java.util.Scanner;

/**
 * Created by sumit.jha on 07/11/18.
 */
public class Hola {
    private static final int MOD = 10003;

    private static boolean isVowel(Character c) {

        c = Character.toUpperCase(c);
        if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
            return true;
        }
        return false;
    }

    public static int solve(String str) {
        int ans = 0;
        int N = str.length();
        for (int i = 0; i < N; i++) {
            if (isVowel(str.charAt(i))) {
                ans = (ans + (N - i)) % MOD;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(solve("ABEC"));
    }
}
