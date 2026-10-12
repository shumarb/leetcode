// Question: https://leetcode.com/problems/sum-of-squares-of-special-elements/description/

class SumOfSquaresOfSpecialElements {
    public int sumOfSquares(int[] nums) {
        int n = nums.length;
        int result = 0;

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                int element = nums[i - 1];
                result += element * element;
            }
        }

        return result;
    }
}