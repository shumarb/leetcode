// Question: https://leetcode.com/problems/unique-paths-ii/description/

class UniquePathsTwo {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        boolean isTest = false;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        /**
         1.  Edge cases: Impossible to reach bottom right
            if either top-left or bottom-right corners are an obstacle.
         */
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }

        /**
         2.  Traversal for first row and first column
             is either moving down only or moving right only respectively,
             and stops when an obstacle is found.
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

        /**
         3.  For each cell dp[i][j], number of ways to reach it from top-left corner
             is the sum of total number of steps to get there by moving right (dp[i][j - 1])
             and the total number of steps to get there by moving down (dp[i - 1][j]).
             If cell is an obstacle, skip it.
         */
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    continue;
                }
                int countDown = (obstacleGrid[i - 1][j] == 1) ? 0 : dp[i - 1][j];
                int countRight = (obstacleGrid[i][j - 1] == 1) ? 0 : dp[i][j - 1];
                dp[i][j] = countDown + countRight;
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
        System.out.println("--------------------------------");
    }
}