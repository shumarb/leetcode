// Question: https://leetcode.com/problems/find-the-power-of-k-size-subarrays-i/description/

class FindThePowerOfKSizeSubarraysOne {
    public int[] resultsArray(int[] nums, int k) {
        int len = nums.length;
        int[] result = new int[len - k + 1];

        for (int i = 0; i <= len - k; i++) {
            boolean isValid = true;
            for (int j = 1; j < k; j++) {
                int current = nums[i + j];
                int previous = nums[i + j - 1];
                if (current - previous != 1) {
                    isValid = false;
                    break;
                }
            }
            result[i] = isValid ? nums[i + k - 1] : -1;
        }

        return result;
    }
}