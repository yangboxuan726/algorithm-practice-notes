public class 搜索二维矩阵II {
    //https://leetcode.cn/problems/search-a-2d-matrix-ii/?envType=study-plan-v2&envId=top-100-liked
    public static void main(String[] args) {
        //输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
        //输出：true
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int target = 5;
        boolean result = searchMatrix(matrix, target);
        System.out.println(result);


    }
    public static boolean searchMatrix(int[][] matrix,int target){
        int i = 0;
        int j = matrix[0].length -1;
        while (i < matrix.length && j >= 0){
            if (matrix[i][j] == target){
                return  true;
            }
            if (matrix[i][j] < target){
                i++;
            }else {
                j--;
            }
        }
        return  false;
    }
}
