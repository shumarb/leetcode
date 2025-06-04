// Question: https://leetcode.com/problems/minimum-operations-to-make-columns-strictly-increasing/description/

class MinimumOperationsToMakeColumnsStrictlyIncreasing {
    public int minimumOperations(int[][] grid) {
        int countOperations = 0;
        for (int j = 0; j < grid[0].length; j++) {
            for (int i = 1; i < grid.length; i++) {
                if (grid[i][j] <= grid[i - 1][j]) {
                    int countIncrement = 1 + Math.abs(grid[i][j] - grid[i - 1][j]);
                    grid[i][j] += countIncrement;
                    countOperations += countIncrement;
                }
            }
        }
        return countOperations;
    }
}