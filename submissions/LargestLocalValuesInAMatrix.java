// Question: https://leetcode.com/problems/largest-local-values-in-a-matrix/description/

class LargestLocalValuesInAMatrix {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] result = new int[n - 2][n - 2];

        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                result[i][j] = findMaximum(grid, i, j);
            }
        }

        return result;
    }

    private int findMaximum(int[][] grid, int startRow, int startColumn) {
        int maximum = 0;

        for (int i = startRow; i < grid.length && i < startRow + 3; i++) {
            for (int j = startColumn; j < grid[0].length && j < startColumn + 3; j++) {
                maximum = Math.max(grid[i][j], maximum);
            }
        }

        return maximum;
    }
}