import java.util.Scanner;

public class 矩阵置零_ACM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] matrix = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        setZeroes(matrix);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j > 0) {
                    result.append(' ');
                }
                result.append(matrix[i][j]);
            }
            if (i < m - 1) {
                result.append('\n');
            }
        }
        System.out.print(result);
    }

    private static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] rowHasZero = new boolean[m];
        boolean[] colHasZero = new boolean[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rowHasZero[i] = true;
                    colHasZero[j] = true;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rowHasZero[i] || colHasZero[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
