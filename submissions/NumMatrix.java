// Question: leetcode.com/problems/range-sum-query-2d-immutable/description/

class NumMatrix {
    private boolean isTest;
    private int[][] prefix;

    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        prefix = new int[m][n];
        isTest = false;

        prefix[0][0] = matrix[0][0];
        for (int i = 1; i < m; i++) {
            prefix[i][0] = matrix[i][0] + prefix[i - 1][0];
        }
        for (int j = 1; j < n; j++) {
            prefix[0][j] = matrix[0][j] + prefix[0][j - 1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                prefix[i][j] = matrix[i][j] + prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1];
            }
        }

        if (isTest) {
            System.out.println("matrix:");
            for (int[] row: matrix) {
                System.out.println(Arrays.toString(row));
            }
            System.out.println("\nprefix:");
            for (int[] row: prefix) {
                System.out.println(Arrays.toString(row));
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int left = col1 > 0 ? prefix[row2][col1 - 1] : 0;
        int overlap = col1 > 0 && row1 > 0 ? prefix[row1 - 1][col1 - 1] : 0;
        int top = row1 > 0 ? prefix[row1 - 1][col2] : 0;

        if (isTest) {
            System.out.println("----------------------------------------------\nregion: [" + row1 + ", " + col1 + "] to [" + row2 + ", " + col2 + "]");
            System.out.println(" * sum of subtrix ending @ [" + row2 + ", " + col2 + "]: " + prefix[row2][col2]);
            System.out.println(" * left | sum of subtrix ending @ [" + row2 + ", " + (col1 - 1) + "]: " + left);
            System.out.println(" * top | sum of subtrix ending @ [" + (row1 - 1) + ", " + col2 + "]: " + top);
            System.out.println(" * overlap (top-left) | sum of subtrix ending @ [" + (row1 - 1) + ", " + (col1 - 1) + "]: " + overlap);
        }

        return prefix[row2][col2] - top - left + overlap;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
