// Question: https://leetcode.com/problems/minimum-value-to-get-positive-step-by-step-sum/description/

class MinimumValueToGetPositiveStepByStepSum class Solution {
    public int minStartValue(int[] nums) {
        boolean isTest = false;
        int n = nums.length;
        int result = nums[0];
        int[] prefix = new int[n];

        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = nums[i] + prefix[i - 1];
            result = Math.min(prefix[i], result);
        }

        if (result < 0) {
            result = Math.abs(result) + 1;
        } else if (result >= 0) {
            result = 1;
        }
        if (isTest) {
            System.out.println("prefix: " + Arrays.toString(prefix) + "\nresult: " + result);
        }

        return result;
    }
}
