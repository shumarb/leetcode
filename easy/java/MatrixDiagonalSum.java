// Question:

class MatrixDiagonalSum {
    public int diagonalSum(int[][] mat) {
        int sumDiagonals = 0;
        int len = mat.length;

        // 1. Edge case 1: Matrix has only 1 element, so return the element
        if (len == 1) {
            return mat[0][0];
        }

        boolean isTest = false;
        for (int i = 0; i < len; i++) {
            if (isTest) {
                System.out.println("adding: mat[" + i + ", " + i + "]: " + mat[i][i]);
            }
            sumDiagonals += mat[i][i];
        }

        int row = 0;
        int col = len - 1;
        while (row < len && col >= 0) {
            if (isTest) {
                System.out.println("adding: mat[" + row + ", " + col + "]: " + mat[row][col]);
            }
            sumDiagonals += mat[row++][col--];
        }

        // 2. Edge case: Odd number of rows & columns
        // This means centre eleemnt counted twice, so remove it from sum of diagonals.
        if (len % 2 != 0) {
            sumDiagonals -= mat[len / 2][len / 2];
        }

        if (isTest) {
            System.out.println("final sumDiagonals: " + sumDiagonals);
        }
        return sumDiagonals;
    }
}