// Question: https://leetcode.com/problems/smallest-index-with-digit-sum-equal-to-index/description/

class SmallestIndexWithDigitSumEqualToIndex {
    public int smallestIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int digitSum = 0;
            int element = nums[i];

            while (element > 0) {
                digitSum += element % 10;
                element /= 10;
            }

            if (digitSum == i) {
                return i;
            }
        }

        return -1;
    }
}
