// Question: https://leetcode.com/problems/unique-paths-ii/description/

class UniquePathsTwo {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        boolean isTest = false;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        // 1. Impossible to reach bottom-right corner if it is an obstacle.
        if (obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }

        /**
         2.  Update first row and first column to determine number of ways to reach each cell.
             If a cell is an obstacle, stop traversing
             as it is impossible to reach cells beyond an obstacle cell.
         */
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            } else {
                dp[i][0] = 1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            } else {
                dp[0][i] = 1;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                /**
                 3.  Current cell's value is 0 if it is obstacle
                     because it is a cell to avoid.
                 */
                if (obstacleGrid[i][j] == 1) {
                    continue;
                }

                /**
                 4.  Obtain number of down and left steps needed to reach current cell.
                     If cell above current cell is an obstacle, number of down steps to reach current cell is 0.
                     If cell left of current cell is an obstacle, number of right steps to reach current cell is 0.
                 */
                int countDownSteps = (obstacleGrid[i - 1][j] == 1) ? 0 : dp[i - 1][j];
                int countLeftSteps = (obstacleGrid[i][j - 1] == 1) ? 0 : dp[i][j - 1];
                dp[i][j] = countDownSteps + countLeftSteps;
            }
        }
        if (isTest) {
            display("obstacleGrid:", obstacleGrid);
            display("dp:", dp);
            System.out.println("result: " + dp[m - 1][n - 1]);
        }

        return dp[m - 1][n - 1];
    }

    private void display(String s, int[][] grid) {
        System.out.println(s);
        for (int[] row: grid) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("------------------------------------------------");
    }
}