// Question: https://leetcode.com/problems/sum-of-digits-in-base-k/description/

class SumOfDigitsInBaseK {
    public int sumBase(int n, int k) {
        int sumBase = 0;
        while (n != 0) {
            sumBase += n % k;
            n /= k;
        }
        return sumBase;
    }
}