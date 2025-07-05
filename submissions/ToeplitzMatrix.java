// Question: https://leetcode.com/problems/toeplitz-matrix/description/

class ToeplitzMatrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int totalRows = matrix.length;
        int totalColumns = matrix[0].length;

        for (int i = 0; i < totalRows - 1; i++) {
            int currentRow = i;
            int currentColumn = 0;
            while (currentRow < totalRows - 1 && currentColumn < totalColumns - 1) {
                if (matrix[currentRow][currentColumn] != matrix[currentRow + 1][currentColumn + 1]) {
                    return false;
                }
                currentRow++;
                currentColumn++;
            }
        }

        for (int i = 1; i < totalColumns - 1; i++) {
            int currentRow = 0;
            int currentColumn = i;
            while (currentRow + 1 < totalRows && currentColumn + 1 < totalColumns) {
                if (matrix[currentRow][currentColumn] != matrix[currentRow + 1][currentColumn + 1]) {
                    return false;
                }
                currentRow++;
                currentColumn++;
            }
        }
        return true;
    }
}