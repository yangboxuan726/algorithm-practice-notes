import java.util.Scanner;

public class 岛屿数量_ACM {
    //https://leetcode.cn/problems/number-of-islands/?envType=study-plan-v2&envId=top-100-liked

    public static void main(String[] args) {
        /**
         * 输入：
         * 4 5
         * 11110
         * 11010
         * 11000
         * 00000
         *输出：1
         * 输入：
         * 4 5
         * 11000
         * 11000
         * 00100
         * 00011
         * 输出：3
         */
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            char[][] arr = new char[n][m];
            for (int i = 0; i < n; i++) {
                String row = sc.next();
                for (int j = 0; j < m; j++) {
                    arr[i][j] = row.charAt(j);
                }
            }

            System.out.println(numIslands(arr));

        }
    }

    public static int numIslands(char[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    dfs(grid, i, j);
                }

            }

        }
        return ans;


    }

    public static void dfs(char[][] arr, int i, int j) {
        if (i < 0 || i >= arr.length || j < 0 || j >= arr[0].length || arr[i][j] != '1') {
            return;
        }
        arr[i][j] = '2';
        dfs(arr, i - 1, j);
        dfs(arr, i + 1, j);
        dfs(arr, i, j - 1);
        dfs(arr, i, j + 1);

    }
}
