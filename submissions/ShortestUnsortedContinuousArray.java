// Question: https://leetcode.com/problems/shortest-unsorted-continuous-subarray/description/

class ShortestUnsortedContinuousArray {
    public int findUnsortedSubarray(int[] nums) {
        boolean isTest = false;
        int left = 0;
        int maximum = Integer.MIN_VALUE;
        int minimum = Integer.MAX_VALUE;
        int n = nums.length;
        int result = 0;
        int right = n - 1;

        if (n == 1) {
            return 0;
        }

        // 1. Find left and right indices of an unsorted subarray.
        while (left <= n - 2 && nums[left] <= nums[left + 1]) {
            left++;
        }
        while (right > 0 && nums[right] >= nums[right - 1]) {
            right--;
        }

        if (right < left) {
            return 0;
        }

        for (int i = left; i <= right; i++) {
            int e = nums[i];
            maximum = Math.max(e, maximum);
            minimum = Math.min(e, minimum);
        }
        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums)
                    + "\n\ninitial unsorted subarray\n * indices: [" + left + ", " + right
                    + "]\n * subarray: " + Arrays.toString(Arrays.copyOfRange(nums, left, right + 1))
                    + "\n * maximum: " + maximum + "\n * minimum: " + minimum);
        }

        /**
         2. All of these elements are part of subarray to be sorted:
             - All elements before left that's greater than minimum found in initial subarray,
             - All elements after right that's smaller than the maximum found in initial subarray.
         */
        while (left >= 1 && nums[left - 1] > minimum) {
            left--;
        }

        while (right <= n - 2 && nums[right + 1] < maximum) {
            right++;
        }

        result = right - left + 1;
        if (isTest) {
            System.out.println("\nshortest unsorted subarray\n * indices: [" + left + ", " + right
                    + "]\n * subarray: " + Arrays.toString(Arrays.copyOfRange(nums, left, right + 1)) + "\nresult: " + result);
        }

        return result;
    }
}
