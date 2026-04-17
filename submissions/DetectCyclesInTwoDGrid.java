// Question: https://leetcode.com/problems/detect-cycles-in-2d-grid/description/

class DetectCyclesInTwoDGrid {
    private boolean[][] isVisited;
    private boolean isCycle;
    private char[][] grid;
    private int depth;
    private int m;
    private int n;

    public boolean containsCycle(char[][] grid) {
        boolean isTest = false;
        m = grid.length;
        n = grid[0].length;
        isVisited = new boolean[m][n];
        this.grid = grid;

        if (isTest) {
            print("grid:");
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isVisited[i][j]) {
                    continue;
                }

                depth = 0;
                isCycle = false;
                dfs(grid[i][j], i, j, -1, -1);
                if (isCycle && depth >= 4) {
                    if (isTest) {
                        print("cycle @ [" + i + ", " + j + "] | depth: " + depth);
                    }
                    return true;
                }
            }
        }

        return false;
    }

    private void dfs(char letter, int row, int column, int parentRow, int parentColumn) {
        if (isCycle || column < 0 || column >= n || row < 0 || row >= m || grid[row][column] != letter) {
            return;
        }

        if (isVisited[row][column]) {
            isCycle = true;
            return;
        }

        depth++;
        isVisited[row][column] = true;

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] direction: directions) {
            int adjacentColumn = column + direction[1];
            int adjacentRow = row + direction[0];

            if (adjacentColumn < 0 || adjacentColumn >= n || adjacentRow < 0 || adjacentRow >= m
                    || grid[adjacentRow][adjacentColumn] != letter || (adjacentRow == parentRow && adjacentColumn == parentColumn)) {
                continue;
            }

            dfs(letter, adjacentRow, adjacentColumn, row, column);
        }
    }

    private void print(String s) {
        System.out.println(s);
        for (char[] row: grid) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("\nisVisited:");
        for (boolean[] row: isVisited) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("------------------------------------------");
    }
}
