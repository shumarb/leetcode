// Question: https://leetcode.com/problems/find-the-power-of-k-size-subarrays-ii/description/

class FindThePowerOfKSizeSubarraysTwo {
    public int[] resultsArray(int[] nums, int k) {
        int countConsecutiveDifferenceOfOne = 0;
        int len = nums.length;
        int[] result = new int[len - k + 1];

        for (int i = 1; i < k; i++) {
            int current = nums[i];
            int previous = nums[i - 1];
            if (current - previous == 1) {
                countConsecutiveDifferenceOfOne++;
            }
        }
        result[0] = (countConsecutiveDifferenceOfOne == k - 1) ? nums[k - 1] : -1;

        for (int i = k; i < len; i++) {
            int remove = nums[i - k];
            int elementBeforeRemove = nums[i - k + 1];
            if (elementBeforeRemove - remove == 1) {
                countConsecutiveDifferenceOfOne--;
            }

            int incoming = nums[i];
            int elementBeforeIncoming = nums[i - 1];
            if (incoming - elementBeforeIncoming == 1) {
                countConsecutiveDifferenceOfOne++;
            }

            result[i - k + 1] = (countConsecutiveDifferenceOfOne == k - 1) ? incoming : -1;
        }

        return result;
    }
}
