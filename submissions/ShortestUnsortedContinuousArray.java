// Question: https://leetcode.com/problems/shortest-unsorted-continuous-subarray/description/

class ShortestUnsortedContinuousArray {
    public int findUnsortedSubarray(int[] nums) {
        boolean isTest = false;
        int left = 0;
        int n = nums.length;
        int right = n - 1;

        while (left < n - 1 && nums[left] <= nums[left + 1]) {
            left++;
        }

        // 1. nums is sorted in non-decreasing order.
        if (left == n - 1) {
            return 0;
        }

        while (right > 0 && nums[right] >= nums[right - 1]) {
            right--;
        }

        int maximum = Integer.MIN_VALUE;
        int minimum = Integer.MAX_VALUE;
        for (int i = left; i <= right; i++) {
            maximum = Math.max(maximum, nums[i]);
            minimum = Math.min(minimum, nums[i]);
        }

        while (left > 0 && nums[left - 1] > minimum) {
            left--;
        }

        while (right < n - 1 && nums[right + 1] < maximum) {
            right++;
        }

        if (isTest) {
            System.out.println("unsorted regiion:\n * left: " + left + " -> e: " + nums[left]);
            System.out.println(" * right: " + right + " -> e: " + nums[right]);
            System.out.println(" * maximum: " + maximum + "\n * minimum: " + minimum);
        }

        return right - left + 1;
    }
}