// Question: https://leetcode.com/problems/smallest-index-with-digit-sum-equal-to-index/description/

class SmallestIndexWithDigitSumEqualToIndex {
    public int smallestIndex(int[] nums) {
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            int element = nums[i];
            int digitSum = 0;

            while (element > 9) {
                digitSum += element % 10;
                element /= 10;
            }
            digitSum += element;
            if (digitSum == i) {
                return i;
            }
        }

        return -1;
    }
}