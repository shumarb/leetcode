// Question: https://leetcode.com/problems/maximum-number-of-fish-in-a-grid/description/

class MaximumNumberOfFishInAGrid {
    private int[][] grid;
    private int m;
    private int n;
    private int sum;

    public int findMaxFish(int[][] grid) {
        boolean isTest = false;
        int result = 0;
        m = grid.length;
        n = grid[0].length;
        sum = 0;
        this.grid = grid;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }

                dfs(i, j);
                result = Math.max(result, sum);
                if (isTest) {
                    System.out.println("component sum starting @ [" + i + ", " + j + "]: " + sum);
                }
                sum = 0;
            }
        }

        return result;
    }


    private void dfs(int row, int column) {
        if (column < 0 || column >= n || row < 0 || row >= m || grid[row][column] == 0) {
            return;
        }

        sum += grid[row][column];
        grid[row][column] = 0;

        dfs(row - 1, column);
        dfs(row + 1, column);
        dfs(row, column - 1);
        dfs(row, column + 1);
    }
}
