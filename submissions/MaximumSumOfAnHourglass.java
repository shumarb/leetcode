// Question: https://leetcode.com/problems/maximum-sum-of-an-hourglass/description/

class MaximumSumOfAnHourglass {
    public int maxSum(int[][] grid) {
        List<int[][]> submatrices = new ArrayList<>();
        boolean isTest = false;
        int m = grid.length;
        int n = grid[0].length;
        int result = 0;

        for (int i = 0; i <= m - 3; i++) {
            for (int j = 0; j <= n - 3; j++) {
                int[][] submatrix = new int[3][3];

                for (int r = 0; r < 3; r++) {
                    for (int c = 0; c < 3; c++) {
                        submatrix[r][c] = grid[i + r][j + c];
                    }
                }
                submatrices.add(submatrix);
            }
        }

        for (int[][] matrix: submatrices) {
            int current = 0;
            current += matrix[0][0];
            current += matrix[0][1];
            current += matrix[0][2];
            current += matrix[1][1];
            current += matrix[2][0];
            current += matrix[2][1];
            current += matrix[2][2];
            result = Math.max(current, result);
        }
        if (isTest) {
            System.out.println("submatrices:");
            for (int[][] matrix: submatrices) {
                for (int[] row: matrix) {
                    System.out.println(Arrays.toString(row));
                }
                System.out.println("------------------------------------");
            }
        }

        return result;
    }
}