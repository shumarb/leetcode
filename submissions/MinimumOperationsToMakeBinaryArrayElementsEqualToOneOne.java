// Question: https://leetcode.com/problems/minimum-operations-to-make-binary-array-elements-equal-to-one-i/description/

class MinimumOperationsToMakeBinaryArrayElementsEqualToOneOne {
    public int minOperations(int[] nums) {
        boolean isTest = false;
        int countOnes = 0;
        int len = nums.length;
        int minOperations = 0;

        for (int bit: nums) {
            if (bit == 1) {
                countOnes++;
            }
        }
        if (countOnes == len) {
            return 0;
        }

        if (isTest) {
            System.out.println("before, nums: " + Arrays.toString(nums));
        }
        for (int i = 0; i <= len - 3; i++) {
            if (nums[i] == 0) {
                if (nums[i] == 0) {
                    nums[i] = 1;
                } else {
                    nums[i] = 0;
                }

                if (nums[i + 1] == 0) {
                    nums[i + 1] = 1;
                } else {
                    nums[i + 1] = 0;
                }

                if (nums[i + 2] == 0) {
                    nums[i + 2] = 1;
                } else {
                    nums[i + 2] = 0;
                }
                if (isTest) {
                    System.out.println(" * so far, nums:  " + Arrays.toString(nums));
                }
                minOperations++;
            }
        }
        if (isTest) {
            System.out.println("after, nums:  " + Arrays.toString(nums));
        }

        countOnes = 0;
        for (int bit: nums) {
            if (bit == 1) {
                countOnes++;
            }
        }

        return countOnes == len ? minOperations : -1;
    }
}