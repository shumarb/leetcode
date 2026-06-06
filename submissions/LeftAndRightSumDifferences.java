// Question: https://leetcode.com/problems/left-and-right-sum-differences/description/

class LeftAndRightSumDifferences {
    public int[] leftRightDifference(int[] nums) {
        boolean isTest = false;
        int n = nums.length;
        int[] leftSum = new int[n];
        int[] result = new int[n];
        int[] rightSum = new int[n];

        for (int i = 1; i < n; i++) {
            leftSum[i] = nums[i - 1] + leftSum[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            rightSum[i] = nums[i + 1] + rightSum[i + 1];
        }
        for (int i = 0; i < n; i++) {
            result[i] = Math.abs(leftSum[i] - rightSum[i]);
        }
        if (isTest) {
            System.out.println("leftSum: " + Arrays.toString(leftSum) + "\nnums:   " + Arrays.toString(nums));
            System.out.println("rightSum: " + Arrays.toString(rightSum) + "\nresult: " + Arrays.toString(result));
        }

        return result;
    }
}
