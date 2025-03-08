// Question: https://leetcode.com/problems/n-repeated-element-in-size-2n-array/description/

class NRepeatedElementInSize2NArray {
    public int repeatedNTimes(int[] nums) {
        boolean isTest = false;

        int maximum = nums[0];
        for (int number: nums) {
            maximum = Math.max(maximum, number);
        }
        boolean[] isNumberPresent = new boolean[maximum + 1];
        for (int i = 0; i < nums.length; i++) {
            if (isNumberPresent[nums[i]]) {
                return nums[i];
            }
            isNumberPresent[nums[i]] = true;
        }

        return -1; // dummy value.
    }
}