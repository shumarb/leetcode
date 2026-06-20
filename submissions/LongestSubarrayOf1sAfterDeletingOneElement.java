// Question: https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/description/

class LongestSubarrayOf1sAfterDeletingOneElement {
    public int longestSubarray(int[] nums) {
        boolean isTest = false;
        int left = 0;
        int limit = 1;
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
            if (isTest) {
                System.out.println("valid | indices [" + left + ", " + right + "] | subarray: " + Arrays.toString(Arrays.copyOfRange(nums, left, right + 1)) + " | limit: " + limit + " | counted length (must delete one): " + (right - left));
            }

            result = Math.max(result, right - left);
        }

        return result;
    }
}
