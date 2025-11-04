// Question: https://leetcode.com/problems/difference-between-ones-and-zeros-in-row-and-column/description/

class DifferenceBetweenOnesAndZerosInRowAndColumn {
    public int[][] onesMinusZeros(int[][] grid) {
        boolean isTest = false;
        int m = grid.length;
        int n = grid[0].length;
        int[][] result = new int[m][n];
        int[] onesCol = new int[n];
        int[] zerosCol = new int[n];
        int[] onesRow = new int[m];
        int[] zerosRow = new int[m];

        for (int i = 0; i < m; i++) {
            int countOnes = countRowOnes(grid[i]);
            onesRow[i] = countOnes;
            zerosRow[i] = n - countOnes;
        }
        for (int j = 0; j < n; j++) {
            int countOnes = countColumnOnes(grid, j);
            onesCol[j] = countOnes;
            zerosCol[j] = m - countOnes;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = onesRow[i] + onesCol[j] - zerosRow[i] - zerosCol[j];
            }
        }
        if (isTest) {
            System.out.println("onesCol: " + Arrays.toString(onesCol) + "\ncolumnZeroes: " + Arrays.toString(zerosCol));
            System.out.println("onesRow: " + Arrays.toString(onesRow) + "\nzerosRow: " + Arrays.toString(zerosRow));
            System.out.println("----------------------------------------------");
            System.out.println("result:");
            for (int[] row: result) {
                System.out.println(Arrays.toString(row));
            }
        }

        return result;
    }

    private int countColumnOnes(int[][] grid, int j) {
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            if (grid[i][j] == 1) {
                count++;
            }
        }

        return count;
    }

    private int countRowOnes(int[] row) {
        int count = 0;

        for (int e: row) {
            if (e == 1) {
                count++;
            }
        }

        return count;
    }
}