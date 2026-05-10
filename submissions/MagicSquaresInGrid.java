// Question: https://leetcode.com/problems/magic-squares-in-grid/description/

class MagicSquaresInGrid {
    public int numMagicSquaresInside(int[][] grid) {
        boolean isTest = false;
        int m = grid.length;
        int n = grid[0].length;
        int result = 0;

        for (int row = 0; row <= m - 3; row++) {
            for (int column = 0; column <= n - 3; column++) {
                int[][] submatrix = new int[3][3];

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        submatrix[i][j] = grid[row + i][column + j];
                    }
                }

                if (isTest) {
                    System.out.println("------------------------------\nsubmatrix:");
                    for (int[] e: submatrix) {
                        System.out.println(Arrays.toString(e));
                    }
                }

                if (isMagicSquare(submatrix)) {
                    if (isTest) {
                        System.out.println("\nvalid");
                    }
                    result++;
                }
            }
        }

        return result;
    }

    private boolean isMagicSquare(int[][] grid) {
        boolean[] isPresent = new boolean[10];
        int column0 = 0;
        int column1 = 0;
        int column2 = 0;
        int diagonal0 = 0;
        int diagonal1 = 0;
        int row0 = 0;
        int row1 = 0;
        int row2 = 0;
        int sum = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int current = grid[i][j];
                if (current < 1 || current > 9 || isPresent[current]) {
                    return false;
                }

                isPresent[current] = true;
            }
        }

        for (int i = 0; i < grid.length; i++) {
            column0 += grid[i][0];
            column1 += grid[i][1];
            column2 += grid[i][2];
        }

        for (int j = 0; j < grid[0].length; j++) {
            row0 += grid[0][j];
            row1 += grid[1][j];
            row2 += grid[2][j];
        }

        for (int i = 0; i < grid.length; i++) {
            diagonal0 += grid[i][i];
        }

        int i = 2;
        int j = 0;
        while (i >= 0 && j < grid[0].length) {
            diagonal1 += grid[i--][j++];
        }

        return column0 == column1 && column1 == column2
                && row0 == row1 && row1 == row2
                && diagonal0 == diagonal1
                && diagonal0 == row0
                && diagonal0 == column0;
    }
}
