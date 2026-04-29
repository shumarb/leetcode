// Question: https://leetcode.com/problems/number-of-enclaves/description/

class NumberOfEnclaves {
    private boolean[][] isVisited;
    private boolean isEnclave;
    private int[][] grid;
    private int count;
    private int m;
    private int n;

    public int numEnclaves(int[][] grid) {
        int result = 0;
        m = grid.length;
        n = grid[0].length;
        isVisited = new boolean[m][n];
        this.grid = grid;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !isVisited[i][j]) {
                    isEnclave = true;
                    count = 0;
                    dfs(i, j);

                    if (isEnclave) {
                        result += count;
                    }
                }
            }
        }

        return result;
    }

    private void dfs(int row, int column) {
        if (column < 0 || column >= n || row < 0 || row >= m|| grid[row][column] == 0 || isVisited[row][column]) {
            return;
        }

        if (column == 0 || column == n - 1 || row == 0 || row == m - 1) {
            isEnclave = false;
            return;
        }

        count++;
        isVisited[row][column] = true;

        dfs(row - 1, column);
        dfs(row + 1, column);
        dfs(row, column - 1);
        dfs(row, column + 1);
    }
}
