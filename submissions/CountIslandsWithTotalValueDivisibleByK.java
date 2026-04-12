// Question: https://leetcode.com/problems/count-islands-with-total-value-divisible-by-k/description/

class CountIslandsWithTotalValueDivisibleByK {
    private int[][] grid;
    private int m;
    private int n;
    private long sum;

    public int countIslands(int[][] grid, int k) {
        boolean isTest = false;
        int result = 0;
        m = grid.length;
        n = grid[0].length;
        sum = 0;
        this.grid = grid;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    dfs(i, j);
                    if (isTest) {
                        System.out.println(" * island @ [" + i + ", " + j + "] -> sum: " + sum);
                    }
                    if (sum % k == 0) {
                        result++;
                    }
                    sum = 0;
                }
            }
        }
        if (isTest) {
            System.out.println("-----------------------------\nresult: " + result);
        }

        return result;
    }

    private void dfs(int row, int column) {
        sum += grid[row][column];
        grid[row][column] = 0;

        if (row - 1 >= 0 && grid[row - 1][column] > 0) {
            dfs(row - 1, column);
        }

        if (row + 1 < m && grid[row + 1][column] > 0) {
            dfs(row + 1, column);
        }

        if (column - 1 >= 0 && grid[row][column - 1] > 0) {
            dfs(row, column - 1);
        }

        if (column + 1 < n && grid[row][column + 1] > 0) {
            dfs(row, column + 1);
        }
    }
}
