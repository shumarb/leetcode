// Question: https://leetcode.com/problems/left-and-right-sum-differences/description/

class LeftAndRightSumDifferences {
    public int[] leftRightDifference(int[] nums) {
        int leftSum = 0;
        int rightSum = 0;
        for (int element: nums) {
            rightSum += element;
        }

        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            rightSum -= value;
            nums[i] = Math.abs(leftSum - rightSum);
            leftSum += value;
        }

        return nums;
    }
}