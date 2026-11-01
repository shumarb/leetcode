// Question: https://leetcode.com/problems/sum-of-square-numbers/description/

class SumOfSquareNumbers {
    public boolean judgeSquareSum(int c) {
        long left = 0;
        long right = (long) Math.sqrt(c);

        while (left <= right) {
            long sum = left * left + right * right;

            if (sum == c) {
                return true;

            } else if (sum < c) {
                left++;

            } else {
                right--;
            }
        }

        return false;
    }
}
