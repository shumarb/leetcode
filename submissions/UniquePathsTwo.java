// Question:

class UniquePathsTwo {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        boolean isTest = false;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // 1. Impossible to reach bottom-right corner if it is an obstacle.
        if (obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }

        if (isTest) {
            display("before, obstacleGrid:", obstacleGrid);
        }

        /**
         2.  Set obstacle cell as -1
             for cell values of first row and column.
         */
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = -1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] != -1) {
                obstacleGrid[i][0] = 1;
            } else {
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] != -1) {
                obstacleGrid[0][i] = 1;
            } else {
                break;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 3. Skip current cell if it's an obstacle.
                if (obstacleGrid[i][j] == -1) {
                    continue;
                }

                /**
                 4.  Current cell is not an obstacle, so number of down steps
                     and right steps to reach current cell.
                     If cell above current cell is an obstacle, impossible to reach current cell by stepping down.
                     If cell left of current cell is an obstacle, impossible to reach current cell by stepping right.
                 */
                int countDownSteps = (obstacleGrid[i - 1][j] == -1) ? 0 : obstacleGrid[i - 1][j];
                int countRightSteps = (obstacleGrid[i][j - 1] == -1) ? 0 : obstacleGrid[i][j - 1];
                obstacleGrid[i][j] = countDownSteps + countRightSteps;
            }
        }
        if (isTest) {
            display("after, obstacleGrid:", obstacleGrid);
            System.out.println("result: " + obstacleGrid[m - 1][n - 1]);
        }

        return obstacleGrid[m - 1][n - 1];
    }

    private void display(String s, int[][] grid) {
        System.out.println(s);
        for (int[] row: grid) {
            System.out.println(" * " + Arrays.toString(row));
        }
        System.out.println("---------------------------------------------------");
    }
}