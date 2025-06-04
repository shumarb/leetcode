// Question: https://leetcode.com/problems/minimum-operations-to-make-array-values-equal-to-k/description/

class MinimumOperationsToMakeArrayValuesEqualToK {
    public int minOperations(int[] nums, int k) {
        boolean[] isNumberChecked = new boolean[101];
        int len = nums.length;
        int minimumOperations = 0;
        for (int i = 0; i < len; i++) {
            int number = nums[i];
            if (number < k) {
                return -1;
            } else if (!isNumberChecked[number] && number > k) {
                isNumberChecked[number] = true;
                minimumOperations++;
            }
        }
        return minimumOperations;
    }
}