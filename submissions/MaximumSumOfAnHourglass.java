// Question: https://leetcode.com/problems/maximum-sum-of-an-hourglass/description/

class MaximumSumOfAnHourglass {
    public int maxSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int result = 0;

        for (int i = 0; i <= m - 3; i++) {
            for (int j = 0; j <= n - 3; j++) {
                int count = 0;
                int sum = 0;

                for (int r = i; r < i + 3; r++) {
                    for (int c = j; c < j + 3; c++) {
                        count++;
                        if (count == 4 || count == 6) {
                            continue;
                        }
                        sum += grid[r][c];
                    }
                }
                result = Math.max(result, sum);
            }
        }

        return result;
    }
}