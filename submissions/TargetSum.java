// Question: https://leetcode.com/problems/target-sum/description/

class TargetSum {
    private int[] nums;
    private int result;
    private int target;

    public int findTargetSumWays(int[] nums, int target) {
        result = 0;
        this.nums = nums;
        this.target = target;

        dfs(0, 0);

        return result;
    }

    private void dfs(int index, int sum) {
        if (index >= nums.length) {
            if (sum == target) {
                result++;
            }
            return;
        }

        dfs(index + 1, sum + nums[index]);
        dfs(index + 1, sum - nums[index]);
    }
}
