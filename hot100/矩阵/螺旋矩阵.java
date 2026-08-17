import java.util.ArrayList;
import java.util.List;

public class 螺旋矩阵 {
    //https://leetcode.cn/problems/spiral-matrix/description/?envType=study-plan-v2&envId=top-100-liked
    public static void main(String[] args) {
        //输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
        //输出：[1,2,3,6,9,8,7,4,5]
        int[][] nums = {{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> result = spiralOrder(nums);
        System.out.println(result);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            // 1. 上边：左 -> 右
            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }
            top++;

            // 2. 右边：上 -> 下
            for (int i = top; i <= bottom; i++) {
                ans.add(matrix[i][right]);
            }
            right--;

            // 3. 下边：右 -> 左
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    ans.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // 4. 左边：下 -> 上
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



