import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 螺旋矩阵_ACM {
    //https://leetcode.cn/problems/spiral-matrix/description/?envType=study-plan-v2&envId=top-100-liked
    public static void main(String[] args) {
        //int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        //List<Integer> result = spiralOrder(matrix);
        //System.out.println(result);
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int[][] matrix = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            List<Integer> result = spiralOrder(matrix);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < result.size(); i++) {
                if (i > 0) {
                    sb.append(' ');
                }
                sb.append(result.get(i));
            }
            System.out.println(sb);
        }
        //3 3 1 2 3 4 5 6 7 8 9 -> 1 2 3 6 9 8 7 4 5
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> ans = new ArrayList<>(m * n);
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = m - 1;
        while (left <= right && top <= bottom) {
            for (int j = left; j <= right; j++) {
                ans.add(matrix[top][j]);
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                ans.add(matrix[i][right]);
            }
            right--;

            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    ans.add(matrix[bottom][j]);
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    ans.add(matrix[i][left]);
                }
                left++;
            }
        }
        return ans;
    }
}
