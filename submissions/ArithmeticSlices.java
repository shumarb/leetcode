// Question: https://leetcode.com/problems/arithmetic-slices/description/

class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] nums) {
        int countValidSubArrays = 0;
        int len = nums.length;
        int totalArithmeticSlices = 0;

        for (int i = 2; i < len; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                countValidSubArrays++;
                totalArithmeticSlices += countValidSubArrays;
            } else {
                countValidSubArrays = 0;
            }
        }

        return totalArithmeticSlices;
    }
}