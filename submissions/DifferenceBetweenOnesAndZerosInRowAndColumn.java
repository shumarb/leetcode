// Question: https://leetcode.com/problems/difference-between-ones-and-zeros-in-row-and-column/description/

class DifferenceBetweenOnesAndZerosInRowAndColumn {
    public int[][] onesMinusZeros(int[][] grid) {
        boolean isTest = false;
        int m = grid.length;
        int n = grid[0].length;
        int[][] result = new int[m][n];
        int[] onesCol = new int[n];
        int[] onesRow = new int[m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    onesCol[j]++;
                    onesRow[i]++;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = onesCol[j] + onesRow[i] - (m - onesCol[j]) - (n - onesRow[i]);
            }
        }
        if (isTest) {
            System.out.println("onesCol: " + Arrays.toString(onesCol) + "\nonesRow: " + Arrays.toString(onesRow));
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