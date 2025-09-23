// Question: https://leetcode.com/problems/longest-consecutive-sequence/description/

class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        // 1. Empty array.
        if (nums.length == 0) {
            return 0;
        }

        int current = 1;
        int longest = 1;

        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] - nums[i - 1] == 1) {
                current++;
            } else {
                longest = Math.max(current, longest);
                current = 1;
            }
        }

        return Math.max(current, longest);
    }
}