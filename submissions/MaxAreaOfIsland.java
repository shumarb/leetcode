// Question: https://leetcode.com/problems/max-area-of-island/description/

class MaxAreaOfIsland {
    private int[][] grid;
    private int m;
    private int n;
    private int result;
    private int sum;

    public int maxAreaOfIsland(int[][] grid) {
        boolean isTest = false;
        m = grid.length;
        n = grid[0].length;
        result = 0;
        sum = 0;
        this.grid = grid;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(i, j);
                    if (isTest) {
                        System.out.println("sum @ [" + i + ", " + j + "]: " + sum);
                    }
                    result = Math.max(result, sum);
                    sum = 0;
                }
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