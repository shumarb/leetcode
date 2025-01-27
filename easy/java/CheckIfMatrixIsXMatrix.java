// Question: https://leetcode.com/problems/check-if-matrix-is-x-matrix/description/

class CheckIfMatrixIsXMatrix {
    private boolean isTest = false;

    public boolean checkXMatrix(int[][] grid) {
        int len = grid.length;

        // 1. Check first diagonal
        if (!isValidDiagonal(grid, len, true)) {
            return false;
        }

        // 2. Check second diagonal
        if (!isValidDiagonal(grid, len, false)) {
            return false;
        }

        // 3. Check non-diagonal values
        for (int i = 0; i < len; i++) {
            if (!isValidRow(grid[i], i, len)) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidRow(int[] row, int rowIndex, int len) {
        for (int i = 0; i < len; i++) {
            // 1. Check if one of or both first and last elements
            // of first and last rows are are 0. If true, it is invalid.
            if (i == rowIndex || i == len - rowIndex - 1) {
                if (row[i] == 0) {
                    return false;
                }

                // 2. Check that entries in rows not first and last rows are not zero.
                // If an element of value non-zero is encountered, it is invalid.
            } else {
                if (row[i] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValidDiagonal(int[][] grid, int len, boolean isFirstDiagonal) {
        for (int i = 0; i < len; i++) {
            int value = isFirstDiagonal ? grid[i][i] : grid[i][len - 1 - i];
            if (value == 0) {
                return false;
            }
        }
        return true;
    }
}