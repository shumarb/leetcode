// Question: https://leetcode.com/problems/smallest-index-with-digit-sum-equal-to-index/description/

class SmallestIndexWithDigitSumEqualToIndex {
    public int smallestIndex(int[] nums) {
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            int digitSum = getDigitSum(nums[i]);
            /**
             1.  The smallest index is the index
                 where the first element whose digit sum is equal to its index
             */
            if (digitSum == i) {
                return i;
            }
        }

        return -1;
    }

    private int getDigitSum(int number) {
        int digitSum = 0;

        while (number != 0) {
            digitSum += (number % 10);
            number /= 10;
        }

        return digitSum;
    }
}