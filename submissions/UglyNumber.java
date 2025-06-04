// Question: https://leetcode.com/problems/ugly-number/description/

class UglyNumber {
    public boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        n = modulo(n, 2);
        n = modulo(n, 3);
        n = modulo(n, 5);
        return n == 1;
    }

    private int modulo(int n, int d) {
        while (n % d == 0) {
            n /= d;
        }
        return n;
    }

}