package prep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by sumit.jha on 05/10/18.
 */
public class Sqrt {

    private static final int MOD = 10000003;



    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true){
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            a = a ^ b;
            b = a ^ b;
            a = a ^ b;
            System.out.println("a = " + a + " b = " + b);
        }

    }
}
