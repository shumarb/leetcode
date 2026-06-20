// Question: https://leetcode.com/problems/max-consecutive-ones-iii/description/

class MaxConsecutiveOnesIII {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int limit = k;
        int n = nums.length;
        int result = 0;

        for (int right = 0; right < n; right++) {
            if (nums[right] == 0) {
                limit--;
            }

            while (limit < 0) {
                if (nums[left++] == 0) {
                    limit++;
                }
            }

            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}
