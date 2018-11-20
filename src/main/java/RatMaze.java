/**
 * Created by sumit.jha on 25/06/18.
 */
public class RatMaze {

    private static boolean isSafe(int x, int y, int N, int[][] maze) {
        if (x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == 1)
            return true;
        return false;
    }

    private static boolean solve(int[][] path, int N, int row, int col, int[][] sol) {
        if (row == N - 1 && col == N - 1) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++)
                    System.out.print(sol[i][j] + "  ");
                System.out.println();
            }
            System.out.println();
            return false;
        }
        if (isSafe(row, col, N, path)) {
            sol[row][col] = 1;
            if (solve(path, N, row + 1, col, sol)) {
                return true;
            }
            if (solve(path, N, row, col + 1, sol)) {
                return true;
            }
            sol[row][col] = 0;
            return false;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] maze = {{1, 1, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}
        };
        int[][] sol = {{0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };

        System.out.println(solve(maze, 4, 0, 0, sol));

    }
}
