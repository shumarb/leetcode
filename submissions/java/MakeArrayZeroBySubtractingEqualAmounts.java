// Question: https://leetcode.com/problems/make-array-zero-by-subtracting-equal-amounts/description/

class MakeArrayZeroBySubtractingEqualAmounts {
    public int minimumOperations(int[] nums) {
        boolean[] numberFrequency = new boolean[101];
        int count = 0;

        for (int number: nums) {
            // 1. Count number of unique non-zero elements in nums.
            if (number > 0 && !numberFrequency[number]) {
                numberFrequency[number] = true;
                count++;
            }
        }

        return count;
    }
}