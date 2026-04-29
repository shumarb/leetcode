// Question: https://leetcode.com/problems/number-of-enclaves/description/

class NumberOfEnclaves {
    private boolean[][] isVisited;
    private int[][] grid;
    private int m;
    private int n;

    public int numEnclaves(int[][] grid) {
        boolean isTest = false;
        int result = 0;
        m = grid.length;
        n = grid[0].length;
        isVisited = new boolean[m][n];
        this.grid = grid;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !isVisited[i][j]) {
                    List<int[]> component = new ArrayList<>();
                    dfs(i, j, component);
                    if (isTest) {
                        System.out.print("component: ");
                        for (int[] e: component) {
                            System.out.print(Arrays.toString(e) + " ");
                        }
                        System.out.println();
                    }
                    if (isEnclave(component)) {
                        result += component.size();
                    }
                }
            }
        }

        return result;
    }

    private boolean isEnclave(List<int[]> component) {
        for (int[] cell: component) {
            int column = cell[1];
            int row = cell[0];
            if (column == 0 || column == n - 1 || row == 0 || row == m -1) {
                return false;
            }
        }

        return true;
    }

    private void dfs(int row, int column, List<int[]> component) {
        if (column < 0 || column >= n || row < 0 || row >= m || grid[row][column] == 0 || isVisited[row][column]) {
            return;
        }

        component.add(new int[] {row, column});
        isVisited[row][column] = true;

        dfs(row - 1, column, component);
        dfs(row + 1, column, component);
        dfs(row, column - 1, component);
        dfs(row, column + 1, component);
    }
}
