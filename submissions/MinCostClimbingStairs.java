// Question: https://leetcode.com/problems/min-cost-climbing-stairs/description/

class MinCostClimbingStairs {
    private int[] cost;
    private int[] dp;

    private int helper(int i) {
        if (i >= cost.length) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int take1Step = cost[i] + helper(i + 1);
        int take2Steps = cost[i] + helper(i + 2);
        dp[i] = Math.min(take1Step, take2Steps);

        return dp[i];
    }

    public int minCostClimbingStairs(int[] cost) {
        boolean isTest = false;
        int n = cost.length;
        int startFrom0 = 0;
        int startFrom1 = 0;
        this.cost = cost;
        this.dp = new int[n];

        Arrays.fill(dp, -1);
        startFrom0 = helper(0);
        if (isTest) {
            System.out.println("startFrom0: " + startFrom0 + "\n * dp: " + Arrays.toString(dp));
        }

        Arrays.fill(dp, -1);
        startFrom1 = helper(1);
        if (isTest) {
            System.out.println("\nstartFrom1: " + startFrom1 + "\n * dp: " + Arrays.toString(dp));
        }

        return Math.min(startFrom0, startFrom1);
    }
}