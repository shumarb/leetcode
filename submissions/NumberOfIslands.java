// Question: https://leetcode.com/problems/number-of-islands/description/

class NumberOfIslands {
    private char[][] grid;
    private int m;
    private int n;

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int result = 0;
        this.grid = grid;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j);
                    result++;
                }
            }
        }

        return result;
    }

    private void dfs(int row, int column) {
        grid[row][column] = '0';

        if (row - 1 >= 0 && grid[row - 1][column] == '1') {
            dfs(row - 1, column);
        }

        if (row + 1 < m && grid[row + 1][column] == '1') {
            dfs(row + 1, column);
        }

        if (column - 1 >= 0 && grid[row][column - 1] == '1') {
            dfs(row, column - 1);
        }

        if (column + 1 < n && grid[row][column + 1] == '1') {
            dfs(row, column + 1);
        }
    }
}
