// Question: https://leetcode.com/problems/count-equal-and-divisible-pairs-in-an-array/description/

class CountEqualAndDivisiblePairsInAnArray {
    public int countPairs(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i < j && nums[i] == nums[j] && ((i * j) % k == 0)) {
                    count++;
                }
            }
        }
        return count;
    }
}