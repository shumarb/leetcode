// Question: https://leetcode.com/problems/number-of-unequal-triplets-in-array/description/

class NumberOfUnequalTripletsInArray {
    public int unequalTriplets(int[] nums) {
        int count = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j + 1; k < len; k++) {
                    if (nums[i] != nums[j] && nums[i] != nums[k] && nums[j] != nums[k]) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}