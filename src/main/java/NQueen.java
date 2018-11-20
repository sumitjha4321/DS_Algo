/**
 * Created by sumit.jha on 25/06/18.
 */
public class NQueen {

    private static void print(int N, int[][] sol) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(sol[i][j] + "  ");
            System.out.println();
        }
        System.out.println();
    }

    private static boolean isSafe(int N, int row, int col, int[][] sol) {
        int i, j;
        // check upper rows
        for (i = 0; i < row; i++) {
            if (sol[i][col] == 1) return false;
        }

        // check upper left diagonal
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (sol[i][j] == 1) return false;
        }

        // check upper right diagonal
        for (i = row, j = col; i >= 0 && j < N; i--, j++) {
            if (sol[i][j] == 1) return false;
        }
        return true;
    }

    /*private static boolean solve(int N, int row, int col, int[][] sol) {
        if (row == N) {
            print(N, sol);
            return true;
        }
        if (isSafe(N, row, col, sol)) {
            for (int j = 0; j < N; j++) {
                sol[row + 1][j] = 1;
                if (solve(N, row + 1, j, sol)) {
                    return true;
                }
                sol[row + 1][j] = 0;
            }
            return false;
        }
        return false;
    }*/

    private static boolean solve(int N, int row, int col, int[][] sol) {
        if (row == N) {
            print(N, sol);
            return false;
        }
        for (int j = 0; j < N; j++) {
            if (isSafe(N, row, j, sol)) {
                sol[row][j] = 1;
                if (solve(N, row + 1, j, sol)) {
                    return true;
                }
                sol[row][j] = 0;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[][] sol = {{0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };
        System.out.println(solve(4, 0, 0, sol));
    }
}
