// Question: https://leetcode.com/problems/convert-1d-array-into-2d-array/description/

class Convert1DArrayInto2DArray {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int[][] result = new int[m][n];
        if (original.length != m * n) {
            return new int[0][0];
        }

        int k = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = original[k++];
            }
        }

        return result;
    }
}