// Question: https://leetcode.com/problems/valid-perfect-square/description/

class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }

        long low = 1;
        long high = (long) num / 2;
        long numLong = num;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (mid * mid == numLong) {
                return true;
            } else if (mid * mid < numLong) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}