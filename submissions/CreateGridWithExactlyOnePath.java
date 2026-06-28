// Question: https://leetcode.com/problems/create-grid-with-exactly-one-path/description/

class CreateGridWithExactlyOnePath {
    private char[][] grid;
    private int column;
    private int m;
    private int n;
    private int row;

    public String[] createGrid(int m, int n) {
        String[] result = new String[m];
        boolean isTest = false;
        column = 0;
        grid = new char[m][n];
        row = 0;
        this.m = m;
        this.n = n;

        if (m == 1) {
            StringBuilder value = new StringBuilder();
            for (int i = 0; i < n; i++) {
                value.append('.');
            }

            result[0] = value.toString();

            return result;
        }

        dfs(true);
        for (int i = row; i < m; i++) {
            grid[i][n - 1] = '.';
        }
        for (int j = column; j < n; j++) {
            grid[m - 1][j] = '.';
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != '.') {
                    grid[i][j] = '#';
                }
            }
        }
        if (isTest) {
            System.out.println("final row: " + row + " | final column: " + column + "\ngrid:");
            for (char[] row: grid) {
                System.out.println(Arrays.toString(row));
            }
        }
        for (int i = 0; i < m; i++) {
            result[i] = new String(grid[i]);
        }

        return result;
    }

    private void dfs(boolean goRightNext) {
        if (column < 0 || row < 0 || column >= n || row >= m) {
            return;
        }

        grid[row][column] = '.';
        if (goRightNext) {
            column++;
            dfs(false);

        } else {
            row++;
            dfs(true);
        }
    }
}
