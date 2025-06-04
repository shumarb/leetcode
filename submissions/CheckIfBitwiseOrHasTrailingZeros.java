// Question: https://leetcode.com/problems/check-if-bitwise-or-has-trailing-zeros/description/

class CheckIfBitwiseOrHasTrailingZeros {
    public boolean hasTrailingZeros(int[] nums) {
        int countEven = 0;
        for (int number: nums) {
            if (number % 2 == 0) {
                countEven++;
                if (countEven >= 2) {
                    return true;
                }
            }
        }
        return false;
    }
}