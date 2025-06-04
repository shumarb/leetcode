// Question: https://leetcode.com/problems/minimum-element-after-replacement-with-digit-sum/description/

class MinimumElementAfterReplacementWithDigitSum {
    public int minElement(int[] nums) {
        int minimumElement = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = getSumOfDigits(nums[i]);
            minimumElement = Math.min(minimumElement, nums[i]);
        }
        return minimumElement;
    }

    private int getSumOfDigits(int num) {
        int sum = 0;
        while (num != 0) {
            sum += (num % 10);
            num /= 10;
        }
        return sum;
    }
}