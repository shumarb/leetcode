// Question: https://leetcode.com/problems/count-sub-islands/description/

class CountSubIslands {
    private boolean isSubIsland;
    private int[][] grid1;
    private int[][] grid2;
    private int m;
    private int n;

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        boolean isTest = false;
        int result = 0;
        isSubIsland = true;
        m = grid2.length;
        n = grid2[0].length;
        this.grid1 = grid1;
        this.grid2 = grid2;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 0) {
                    continue;
                }

                dfs(i, j);
                if (isSubIsland) {
                    if (isTest) {
                        System.out.println(" * sub island @ [" + i + ", " + j + "]");
                    }
                    result++;
                }
                isSubIsland = true;
            }
        }
        if (isTest) {
            System.out.println("----------------------\nresult: " + result);
        }

        return result;
    }

    private void dfs(int row, int column) {
        if (column < 0 || column >= n || row < 0 || row >= m || grid2[row][column] == 0) {
            return;
        }

        // 1. Current cell in grid2 is an island not grid1, so current component is not a sub island.
        if (grid1[row][column] == 0) {
            isSubIsland = false;
            return;
        }

        // 2. Mark cell as visited.
        grid2[row][column] = 0;

        dfs(row - 1, column);
        dfs(row + 1, column);
        dfs(row, column - 1);
        dfs(row, column + 1);
    }
}
