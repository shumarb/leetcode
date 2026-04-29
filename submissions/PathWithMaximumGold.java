// Question: https://leetcode.com/problems/path-with-maximum-gold/description/

class PathWithMaximumGold {
    private int[][] grid;
    private int m;
    private int n;
    private int result;

    public int getMaximumGold(int[][] grid) {
        boolean isTest = false;
        m = grid.length;
        n = grid[0].length;
        result = 0;
        this.grid = grid;

        if (isTest) {
            System.out.println("grid: ");
            for (int[] row: grid) {
                System.out.println(Arrays.toString(row));
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    dfs(i, j, grid[i][j]);
                }
            }
        }
        if (isTest) {
            System.out.println("---------------------\nresult: " + result);
        }

        return result;
    }

    private void dfs(int row, int column, int sum) {
        int gold = grid[row][column];

        result = Math.max(result, sum);

        // 1. mark as visited and explore.
        grid[row][column] = 0;

        if (row - 1 >= 0 && grid[row - 1][column] > 0) {
            dfs(row - 1, column, sum + grid[row - 1][column]);
        }
        if (row + 1 < m && grid[row + 1][column] > 0) {
            dfs(row + 1, column, sum + grid[row + 1][column]);
        }
        if (column - 1 >= 0 && grid[row][column - 1] > 0) {
            dfs(row, column - 1, sum + grid[row][column - 1]);
        }
        if (column + 1 < n && grid[row][column + 1] > 0) {
            dfs(row, column + 1, sum + grid[row][column + 1]);
        }

        // 2. backtrack.
        grid[row][column] = gold;
    }
}
