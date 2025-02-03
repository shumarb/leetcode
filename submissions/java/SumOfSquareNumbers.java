// Question: https://leetcode.com/problems/sum-of-square-numbers/description/

class SumOfSquareNumbers {
    public boolean judgeSquareSum(int c) {
        long low = 0;
        long high = (long) Math.sqrt(c);

        while (low <= high) {
            if (low * low + high * high == (long) c) {
                return true;
            } else if (low * low + high * high < (long) c) {
                low++;
            } else {
                high--;
            }
        }

        return false;
    }
}