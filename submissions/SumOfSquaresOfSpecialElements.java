// Question: https://leetcode.com/problems/sum-of-squares-of-special-elements/description/

class SumOfSquaresOfSpecialElements {
    public int sumOfSquares(int[] nums) {
        int n = nums.length;
        int sumOfSquaresOfSpecialElements = 0;
        boolean isTest = false;

        for (int i = 0; i < n; i++) {
            if (n % (i + 1) == 0) {
                if (isTest) {
                    System.out.println("special: " + nums[i] + " | index: " + (i + 1));
                }
                sumOfSquaresOfSpecialElements += nums[i] * nums[i];
            }
        }

        return sumOfSquaresOfSpecialElements;
    }
}