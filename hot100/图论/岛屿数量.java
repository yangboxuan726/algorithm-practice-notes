public class 岛屿数量 {
    //https://leetcode.cn/problems/number-of-islands/?envType=study-plan-v2&envId=top-100-liked

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        int result = numIslands(grid);
        System.out.println(result);
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
        if (i < 0 || i == arr.length || j < 0 || j == arr[0].length || arr[i][j] != '1') {
            return;
        }
        arr[i][j] = '2';
        dfs(arr, i - 1, j);
        dfs(arr, i + 1, j);
        dfs(arr, i, j - 1);
        dfs(arr, i, j + 1);
    }
}
