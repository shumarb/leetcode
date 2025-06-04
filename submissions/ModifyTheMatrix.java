// Question: https://leetcode.com/problems/modify-the-matrix/description/

class ModifyTheMatrix {
    public int[][] modifiedMatrix(int[][] matrix) {
        boolean isTest = false;
        for (int i = 0; i < matrix[0].length; i++) {
            int columnMaximum = findColumnMaximum(i, matrix);
            if (isTest) {
                System.out.println("index " + i + " | columnMaximum: " + columnMaximum);
            }
            update(i, columnMaximum, matrix);
        }
        return matrix;
    }

    private void update(int column, int columnMaximum, int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][column] == -1) {
                matrix[i][column] = columnMaximum;
            }
        }
    }

    private int findColumnMaximum(int column, int[][] matrix) {
        int maximum = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            maximum = Math.max(maximum, matrix[i][column]);
        }
        return maximum;
    }
}