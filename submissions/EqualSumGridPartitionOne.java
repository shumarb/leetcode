// Question: https://leetcode.com/problems/equal-sum-grid-partition-i/description/

class EqualSumGridPartitionOne {
    public boolean canPartitionGrid(int[][] grid) {
        boolean isTest = false;
        int m = grid.length;
        int n = grid[0].length;
        long prefix = 0;
        long total = 0;

        // 1. Edge cases: grid has 1 row.

        for (int[] row: grid) {
            for (int e: row) {
                total += e;
            }
        }

        // 1. Horizontal cut.
        for (int i = 0; i < m - 1; i++) {
            long rowSum = getSum(grid[i]);
            prefix += rowSum;
            if (prefix == total - prefix) {
                if (isTest) {
                    System.out.println(" * valid @ row " + i + " | prefix: " + prefix + " | complement: " + (total - prefix));
                }
                return true;
            }
        }

        // 2. Vertical cut.
        prefix = 0;
        for (int j = 0; j < n - 1; j++) {
            long columnSum = 0;
            for (int i = 0; i < m; i++) {
                columnSum += grid[i][j];
            }

            prefix += columnSum;
            if (prefix == total - prefix) {
                if (isTest) {
                    System.out.println(" * valid cut @ column " + j + " | prefix: " + prefix + " | complement: " + (total - prefix));
                }

                return true;
            }
        }

        return false;
    }

    private long getSum(int[] arr) {
        long result = 0;

        for (int e: arr) {
            result += e;
        }

        return result;
    }
}
