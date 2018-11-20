/**
 * Created by sumit.jha on 25/06/18.
 */
public class Sudoku {

    static class Pair {
        int row, col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private static void print(int N, int[][] sol) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(sol[i][j] + "  ");
            System.out.println();
        }
        System.out.println();
    }

    private static Pair findUnfilledPos(int N, int[][] grid) {
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                if (grid[row][col] == 0) {
                    return new Pair(row, col);
                }
            }
        }
        return new Pair(-1, -1);
    }

    private static boolean isSafe(int N, int[][] grid, int row, int col, int num) {
        for (int i = 0; i < N; i++) {
            if (i != row && grid[i][col] == num) {
                return false;
            }
        }
        for (int i = 0; i < N; i++) {
            if (i != col && grid[row][i] == num) {
                return false;
            }
        }
        return true;
    }

    private static boolean solve(int N, int[][] grid) {

        Pair pair = findUnfilledPos(N, grid);
        if (pair.row == -1 && pair.col == -1) {
            print(N, grid);
            return false;
        }

        for (int i = 1; i <= 9; i++) {
            if (isSafe(N, grid, pair.row, pair.col, i)) {
                grid[pair.row][pair.col] = i;
                if (solve(N, grid)) {
                    return true;
                }
                grid[pair.row][pair.col] = 0;
            }

        }
        return false;
    }

    public static void main(String[] args) {

        int[][] grid = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}};

        solve(9, grid);


    }
}
