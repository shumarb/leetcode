// Question: https://leetcode.com/problems/powx-n/description/

class PowXN {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            x = 1 / x;
            n *= -1;
        }

        return helper(x, n);
    }

    private double helper(double x, long n) {
        if (n == 0) {
            return 1;
        }

        double half = helper(x, n / 2);

        return n % 2 == 0 ? half * half : x * half * half;
    }
}