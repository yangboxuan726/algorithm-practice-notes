import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 腐烂的橘子_ACM {

    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {
        /**
         * 输入：
         * 3 3
         * 2 1 1
         * 1 1 0
         * 0 1 1
         * 输出：4
         */
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int[][] grid = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            System.out.println(orangesRotting(grid));
        }
        sc.close();
    }

    public static int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        List<int[]> queue = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                } else if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        int minutes = 0;
        while (fresh > 0 && !queue.isEmpty()) {
            minutes++;
            List<int[]> currentLevel = queue;
            queue = new ArrayList<>();

            for (int[] orange : currentLevel) {
                for (int[] direction : DIRECTIONS) {
                    int nextRow = orange[0] + direction[0];
                    int nextCol = orange[1] + direction[1];
                    if (nextRow >= 0 && nextRow < m
                            && nextCol >= 0 && nextCol < n
                            && grid[nextRow][nextCol] == 1) {
                        grid[nextRow][nextCol] = 2;
                        fresh--;
                        queue.add(new int[]{nextRow, nextCol});
                    }
                }
            }
        }

        return fresh == 0 ? minutes : -1;
    }
}
