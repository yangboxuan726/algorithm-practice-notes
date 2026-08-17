import java.util.Arrays;

public class 旋转图像 {
    //https://leetcode.cn/problems/rotate-image/?envType=study-plan-v2&envId=top-100-liked
    public static void main(String[] args) {
        //输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
        //输出：[[7,4,1],[8,5,2],[9,6,3]]
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        rotate( matrix );
        System.out.println(Arrays.deepToString( matrix ));
    }
    public static void rotate(int[][] matrix){
        int n = matrix.length;
        for (int i = 0; i < n;i++){
            for (int j = 0; j < i;j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        for (int[] row : matrix){
            for (int i = 0; i < n/2;i++){
                int tmp = row[i];
                row[i] = row[n-i-1];
                row[n-i-1] = tmp;
            }
        }
    }


}
