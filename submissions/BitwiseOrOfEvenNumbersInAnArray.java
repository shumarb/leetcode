// Question: https://leetcode.com/problems/bitwise-or-of-even-numbers-in-an-array/description/

class BitwiseOrOfEvenNumbersInAnArray {
    public int evenNumberBitwiseORs(int[] nums) {
        int result = 0;

        for (int number: nums) {
            if (number % 2 == 0) {
                result |= number;
            }
        }

        return result;
    }
}