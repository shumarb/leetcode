// Question: https://leetcode.com/problems/number-of-arithmetic-triplets/description/

class NumberOfArithmeticTriplets {
    public int arithmeticTriplets(int[] nums, int diff) {
        int count = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j + 1; k < len; k++) {
                    if (nums[j] - nums[i] != diff) {
                        continue;
                    }
                    if (nums[k] - nums[j] == diff) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}