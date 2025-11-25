// Question: https://leetcode.com/problems/number-of-subarrays-with-bounded-maximum/description/

class NumberOfSubarraysWithBoundedMaximum {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        return count(nums, right) - count(nums, left - 1);
    }

    private int count(int[] nums, int bound) {
        int current = 0;
        int total = 0;

        for (int e: nums) {
            if (e <= bound) {
                current++;
                total += current;
            } else {
                current = 0;
            }
        }

        return total;
    }
}