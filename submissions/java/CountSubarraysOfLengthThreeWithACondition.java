// Question: https://leetcode.com/problems/count-subarrays-of-length-three-with-a-condition/description/

class CountSubarraysOfLengthThreeWithACondition {
    public int countSubarrays(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if ((double) (nums[i] + nums[i + 2]) == (0.5 * (double) nums[i + 1])) {
                count++;
            }
        }
        return count;
    }
}