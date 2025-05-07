// Question: https://leetcode.com/problems/minimum-operations-to-make-array-values-equal-to-k/description/

class MinimumOperationsToMakeArrayValuesEqualToK {
    public int minOperations(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] < k) {
                return -1;
            } else if (nums[i] > k) {
                set.add(nums[i]);
            }
        }
        return set.size();
    }
}