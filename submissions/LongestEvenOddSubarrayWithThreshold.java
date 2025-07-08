// Question: https://leetcode.com/problems/longest-even-odd-subarray-with-threshold/description/

class LongestEvenOddSubarrayWithThreshold {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int longest = 0;

        for (int l = 0; l < nums.length; l++) {
            if (nums[l] % 2 != 0 || nums[l] > threshold) {
                continue;
            }

            // 1. Handle single-sized nums.
            longest = Math.max(longest, 1);
            for (int r = l + 1; r < nums.length; r++) {
                if (nums[r] > threshold || (nums[r] % 2 == nums[r - 1] % 2)) {
                    break;
                }
                longest = Math.max(longest, r - l + 1);
            }
        }

        return longest;
    }
}