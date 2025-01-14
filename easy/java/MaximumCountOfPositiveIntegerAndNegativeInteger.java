// Question: https://leetcode.com/problems/maximum-count-of-positive-integer-and-negative-integer/description/

class MaximumCountOfPositiveIntegerAndNegativeInteger {
    public int maximumCount(int[] nums) {
        int countPositive = 0;
        int countNegative = 0;
        for (int x: nums) {
            if (x < 0) {
                countNegative++;
            }
            if (x > 0) {
                countPositive++;
            }
        }
        return Math.max(countPositive, countNegative);
    }
}