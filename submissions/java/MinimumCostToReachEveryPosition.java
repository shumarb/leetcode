// Question: https://leetcode.com/problems/minimum-cost-to-reach-every-position/description/

class MinimumCostToReachEveryPosition {
    public int[] minCosts(int[] cost) {
        int len = cost.length;
        for (int i = 1; i < len; i++) {
            cost[i] = Math.min(cost[i - 1], cost[i]);
        }
        return cost;
    }
}