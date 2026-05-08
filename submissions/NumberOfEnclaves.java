// Question: https://leetcode.com/problems/number-of-enclaves/description/

class NumberOfEnclaves {
    private int[][] grid;
    private int m;
    private int n;

    public int numEnclaves(int[][] grid) {
        boolean isTest = false;
        int result = 0;
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;

        if (isTest) {
            print("before:");
        }

        for (int i = 0; i < m; i++) {
            dfs(i, 0);
            dfs(i, n - 1);
        }
        for (int j = 0; j < n; j++) {
            dfs(0, j);
            dfs(m - 1, j);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    result++;
                }
            }
        }

        if (isTest) {
            print("after:");
            System.out.println("result: " + result);
        }

        return result;
    }

    private void dfs(int row, int column) {
        if (column < 0 || column >= n || row < 0 || row >= m || grid[row][column] == 0) {
            return;
        }

        grid[row][column] = 0;

        dfs(row - 1, column);
        dfs(row + 1, column);
        dfs(row, column - 1);
        dfs(row, column + 1);
    }

    private void print(String s) {
        System.out.println(s);
        for (int[] row: grid) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("------------------------------------");
    }
}
