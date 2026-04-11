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
        if (row < 0 || column < 0 || row >= m || column >= n || grid[row][column] == '0') {
            return;
        }

        grid[row][column] = '0';

        dfs(row - 1, column);
        dfs(row + 1, column);
        dfs(row, column - 1);
        dfs(row, column + 1);
    }
}
