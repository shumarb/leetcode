// Question: https://leetcode.com/problems/count-alternating-subarrays/description/

class CountAlternatingSubarrays {
    public long countAlternatingSubarrays(int[] nums) {
        long count = 1;
        long result = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                result++;
                count = 1;
            } else {
                result += ++count;
            }
        }

        return result;
    }
}