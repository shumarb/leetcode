// Question: https://leetcode.com/problems/maximum-sum-of-an-hourglass/description/

class MaximumSumOfAnHourglass class Solution {
    public int maxSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int result = 0;

        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                int sum = grid[i - 1][j - 1] + grid[i - 1][j] + grid[i - 1][j + 1]
                        + grid[i][j]
                        + grid[i + 1][j - 1] + grid[i + 1][j] + grid[i + 1][j + 1];
                result = Math.max(result, sum);
            }
        }

        return result;
    }
}