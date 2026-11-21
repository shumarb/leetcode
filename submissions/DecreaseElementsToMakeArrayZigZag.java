// Question: https://leetcode.com/problems/decrease-elements-to-make-array-zigzag/description/

class DecreaseElementsToMakeArrayZigZag {
    public int movesToMakeZigzag(int[] nums) {
        int n = nums.length;
        long evenIndicesValleys = 0;
        long oddIndicesValleys = 0;

        if (n == 1) {
            return 0;

        } else if (n == 2) {
            return nums[0] == nums[1] ? 1 : 0;
        }

        // 1. Odd indices are valleys.
        for (int i = 1; i < n; i += 2) {
            int left = nums[i - 1];
            int right = i + 1 < n ? nums[i + 1] : Integer.MAX_VALUE;
            int smaller = Math.min(left, right);
            oddIndicesValleys += Math.max(0, nums[i] - smaller + 1);
        }

        // 2. Even indices are valleys.
        for (int i = 0; i < n; i += 2) {
            int left = i == 0 ? Integer.MAX_VALUE : nums[i - 1];
            int right = i + 1 < n ? nums[i + 1] : Integer.MAX_VALUE;
            int smaller = Math.min(left, right);
            evenIndicesValleys += Math.max(0, nums[i] - smaller + 1);
        }

        return (int) Math.min(evenIndicesValleys, oddIndicesValleys);
    }
}
