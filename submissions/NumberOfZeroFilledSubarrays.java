// Question: https://leetcode.com/problems/number-of-zero-filled-subarrays/description/

class NumberOfZeroFilledSubarrays {
    public long zeroFilledSubarray(int[] nums) {
        long countTotal = 0;
        long countCurrent = 0;

        for (int number: nums) {
            if (number == 0) {
                countCurrent++;
                countTotal += countCurrent;
            } else {
                countCurrent = 0;
            }
        }

        return countTotal;
    }
}