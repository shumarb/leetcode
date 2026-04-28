// Question: https://leetcode.com/problems/path-with-maximum-gold/description/

class PathWithMaximumGold {
    private boolean[][] isVisited;
    private int[][] grid;
    private int m;
    private int n;
    private int result;

    public int getMaximumGold(int[][] grid) {
        boolean isTest = false;
        m = grid.length;
        n = grid[0].length;
        isVisited = new boolean[m][n];
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
                if (grid[i][j] > 0 && !isVisited[i][j]) {
                    dfs(i, j, 0);
                }
            }
        }
        if (isTest) {
            System.out.println("---------------------\nresult: " + result);
        }

        return result;
    }

    private void dfs(int row, int column, int sum) {
        if (column < 0 || column >= n || row < 0 || row >= m || isVisited[row][column] || grid[row][column] == 0) {
            return;
        }

        sum += grid[row][column];
        result = Math.max(result, sum);

        isVisited[row][column] = true;

        dfs(row - 1, column, sum);
        dfs(row + 1, column, sum);
        dfs(row, column - 1, sum);
        dfs(row, column + 1, sum);

        isVisited[row][column] = false;
    }
}
