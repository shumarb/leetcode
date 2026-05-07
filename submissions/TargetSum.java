// Question: https://leetcode.com/problems/target-sum/description/

class TargetSum {
    private Map<String, Integer> memo;
    private int[] nums;
    private int target;

    public int findTargetSumWays(int[] nums, int target) {
        memo = new HashMap<>();
        this.nums = nums;
        this.target = target;

        return dfs(0, 0);
    }

    private int dfs(int index, int sum) {
        if (index >= nums.length) {
            return sum == target ? 1 : 0;
        }

        String key = index + ", " + sum;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int countWaysIfAdd = dfs(index + 1, sum + nums[index]);
        int countWaysIfSubtract = dfs(index + 1, sum - nums[index]);

        memo.put(key, countWaysIfAdd + countWaysIfSubtract);

        return memo.get(key);
    }
}
