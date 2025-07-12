// Question: https://leetcode.com/problems/reshape-the-matrix/description/

class ReshapeTheMatrix {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int totalColumns = mat[0].length;
        int totalRows = mat.length;

        if (totalRows * totalColumns != r * c) {
            return mat;
        }

        int[][] result = new int[r][c];
        int[] numbers = new int[totalRows * totalColumns];
        int k = 0;

        for (int[] row: mat) {
            for (int element: row) {
                numbers[k++] = element;
            }
        }
        k = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                result[i][j] = numbers[k++];
            }
        }

        return result;
    }
}