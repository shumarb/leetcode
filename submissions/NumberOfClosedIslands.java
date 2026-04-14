// Question: https://leetcode.com/problems/number-of-closed-islands/description/

class NumberOfClosedIslands {
    private int[][] grid;
    private int m;
    private int n;

    public int closedIsland(int[][] grid) {
        boolean isTest = false;
        int result = 0;
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;

        if (isTest) {
            print("before:");
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    List<int[]> component = new ArrayList<>();
                    dfs(i, j, component);
                    if (isTest) {
                        System.out.print(" * component: ");
                        for (int[] point: component) {
                            System.out.print(Arrays.toString(point) + " ");
                        }
                    }
                    if (isClosedIsland(component)) {
                        if (isTest) {
                            System.out.println("| closed island");
                        }
                        result++;
                    } else {
                        if (isTest) {
                            System.out.println();
                        }
                    }
                    component.clear();
                }
            }
        }
        if (isTest) {
            print("-----------------------------\nafter:");
        }

        return result;
    }

    private boolean isClosedIsland(List<int[]> component) {
        for (int[] point: component) {
            int column = point[1];
            int row = point[0];

            if (column == 0 || column == n - 1 || row == 0 || row == m - 1) {
                return false;
            }
        }
        return true;
    }

    private void dfs(int row, int column, List<int[]> component) {
        if (column < 0 || column >= n || row < 0 || row >= m || grid[row][column] == 1) {
            return;
        }

        component.add(new int[] {row, column});
        grid[row][column] = 1;

        dfs(row - 1, column, component);
        dfs(row + 1, column, component);
        dfs(row, column - 1, component);
        dfs(row, column + 1, component);
    }

    private void print(String s) {
        System.out.println(s);
        for (int[] row: grid) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("-----------------------------");
    }
}
