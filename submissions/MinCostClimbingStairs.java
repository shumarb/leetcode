// Question: https://leetcode.com/problems/min-cost-climbing-stairs/description/

class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        boolean isTest = false;

        if (isTest) {
            System.out.println("before, cost: " + Arrays.toString(cost));
        }
        for (int i = cost.length - 3; i >= 0; i--) {
            cost[i] += Math.min(cost[i + 1], cost[i + 2]);
        }
        if (isTest) {
            System.out.println("after, cost:  " + Arrays.toString(cost) + "\nresult: " + Math.min(cost[0], cost[1]));
        }

        return Math.min(cost[0], cost[1]);
    }
}