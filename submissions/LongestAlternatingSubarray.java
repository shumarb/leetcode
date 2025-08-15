// Question: https://leetcode.com/problems/longest-alternating-subarray/description/

class LongestAlternatingSubarray {
    public int alternatingSubarray(int[] nums) {
        boolean isTest = false;
        int longestLength = -1;
        int n = nums.length;

        for (int start = 0; start < n - 1; start++) {
            if (nums[start + 1] - nums[start] != 1) {
                continue;
            }

            int currentLength = 2;
            for (int i = start + 2; i < n; i++) {
                if (nums[i] == nums[i - 2]) {
                    currentLength++;
                } else {
                    break;
                }
            }

            longestLength = Math.max(currentLength, longestLength);
        }

        return longestLength;
    }
}