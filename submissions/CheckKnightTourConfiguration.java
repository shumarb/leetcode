// Question: https://leetcode.com/problems/check-knight-tour-configuration/description/

class CheckKnightTourConfiguration {
    private boolean[][] isVisited;
    private boolean isTest;
    private int[][] grid;
    private int m;
    private int n;
    private int visitedCells;

    public boolean checkValidGrid(int[][] grid) {
        isTest = false;
        m = grid.length;
        n = grid[0].length;
        visitedCells = 0;
        isVisited = new boolean[m][n];
        this.grid = grid;

        if (isTest) {
            System.out.println("grid:");
            for (int[] row: grid) {
                System.out.println(Arrays.toString(row));
            }
            System.out.println("------------------------------------");
        }

        dfs(0, 0, 0);

        if (isTest) {
            System.out.println("------------------------------------\nvisitedCells: " + visitedCells);
            System.out.println("\nisVisited:");
            for (boolean[] row: isVisited) {
                System.out.println(Arrays.toString(row));
            }
        }

        return visitedCells == m * n;
    }

    private void dfs(int row, int column, int value) {
        if (column < 0 || column >= n || row < 0 || row >= m || isVisited[row][column] || grid[row][column] != value) {
            return;
        }

        if (isTest) {
            System.out.println(" * " + value + ": [" + row + ", " + column + "]");
        }

        int[][] directions = {
                {2, -1},
                {2, 1},
                {-2, 1},
                {-2, -1},
                {1, 2},
                {1, -2},
                {-1, 2},
                {-1, -2}
        };

        isVisited[row][column] = true;
        visitedCells++;
        value++;

        for (int[] direction: directions) {
            int nextColumn = column + direction[1];
            int nextRow = row + direction[0];

            if (nextColumn < 0 || nextColumn >= n
                    || nextRow < 0 || nextRow >= m
                    || isVisited[nextRow][nextColumn]
                    || grid[nextRow][nextColumn] != value) {
                continue;
            }

            dfs(nextRow, nextColumn, value);
        }
    }
}
