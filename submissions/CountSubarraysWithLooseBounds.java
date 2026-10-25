// Question: https://leetcode.com/problems/count-subarrays-with-loose-bounds/description/

class CountSubarraysWithLooseBounds {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int len = 0;
        long result = 0;

        for (int e: nums) {
            if (e >= minK && e <= maxK) {
                result += ++len;

            } else {
                len = 0;
            }
        }

        return result;
    }
}
