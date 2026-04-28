// Question: https://leetcode.com/problems/unique-paths-iii/

class UniquePathsThree {
    private boolean[][] isVisited;
    private boolean isTest;
    private int[][] grid;
    private int m;
    private int n;
    private int result;

    public int uniquePathsIII(int[][] grid) {
        int countNonObstaclesCells = 0;
        int endColumn = -1;
        int endRow = -1;
        int startRow = -1;
        int startColumn = -1;
        isTest = false;
        m = grid.length;
        n = grid[0].length;
        isVisited = new boolean[m][n];
        result = 0;
        this.grid = grid;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == -1) {
                    continue;
                }

                countNonObstaclesCells++;
                if (grid[i][j] == 1) {
                    startColumn = j;
                    startRow = i;
                }

                if (grid[i][j] == 2) {
                    endColumn = j;
                    endRow = i;
                }
            }
        }
        if (isTest) {
            System.out.println("grid:");
            for (int[] row: grid) {
                System.out.println(Arrays.toString(row));
            }
            System.out.println("source: [" + startRow + ", " + startColumn + "]");
            System.out.println("destination: [" + endRow + ", " + endColumn + "]\ncountNonObstaclesCells: " + countNonObstaclesCells);
        }

        dfs(startRow, startColumn, countNonObstaclesCells);
        if (isTest) {
            System.out.println("-----------------------------\nresult: " + result);
        }

        return result;
    }

    private void dfs(int row, int column, int remainingValidCells) {
        if (column < 0 || column >= n || row < 0 || row >= m || isVisited[row][column] || grid[row][column] == -1) {
            return;
        }

        if (grid[row][column] == 2) {
            // 1. All non-obstacles excluding ending square visited, so valid path found.
            if (remainingValidCells == 1) {
                result++;
            }
            return;
        }

        // 2. Explore current path and backtrack.
        isVisited[row][column] = true;

        dfs(row - 1, column, remainingValidCells - 1);
        dfs(row + 1, column, remainingValidCells - 1);
        dfs(row, column - 1, remainingValidCells - 1);
        dfs(row, column + 1, remainingValidCells - 1);

        isVisited[row][column] = false;
    }
}
