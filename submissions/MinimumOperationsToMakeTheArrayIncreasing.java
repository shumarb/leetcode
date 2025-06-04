// Question: https://leetcode.com/problems/minimum-operations-to-make-the-array-increasing/description/

class MinimumOperationsToMakeTheArrayIncreasing {
    public int minOperations(int[] nums) {
        int count = 0;
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            int current = nums[i];
            int previous = nums[i - 1];
            if (current <= previous) {
                int difference = previous - current + 1;
                count += difference;
                nums[i] += difference;
            }
        }
        return count;
    }
}