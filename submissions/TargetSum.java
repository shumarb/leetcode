// Question: https://leetcode.com/problems/target-sum/description/

class TargetSum {
    private int[] nums;
    private int target;

    public int findTargetSumWays(int[] nums, int target) {
        this.nums = nums;
        this.target = target;

        return dfs(0, 0);
    }

    private int dfs(int index, int sum) {
        if (index >= nums.length) {
            return sum == target ? 1 : 0;
        }

        int countStepsIfAdd = dfs(index + 1, sum + nums[index]);
        int countStepsIfSubtract = dfs(index + 1, sum - nums[index]);

        return countStepsIfAdd + countStepsIfSubtract;
    }
}
