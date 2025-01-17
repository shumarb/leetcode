// Question: https://leetcode.com/problems/sqrtx/description/

class SqrtX {
    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }

        // 1. Use of long to ensure no integer overflow
        // during computation
        long left = 1;

        // 2. Sqrt(x) guaranteed to be <= (x / 2)
        long right = (long) x / 2;

        // 3. Largest value < x such that (value * value) <= x
        long val = 0;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            // 1. Obtain exact answer of sqrt(x)
            if (mid * mid == x) {
                return (int) mid;

                // 2. Obtain floor of sqrt(x)
                // This could be largest value < x such that (value * value) <= x
                // so take note if its value and check from [mid + 1, high]
            } else if (mid * mid < x) {
                val = mid;
                left = mid + 1;

                // 3. mid > sqrt(x), so exclude all values from right onwards
            } else {
                right = mid - 1;
            }
        }

        return (int) val;
    }
}