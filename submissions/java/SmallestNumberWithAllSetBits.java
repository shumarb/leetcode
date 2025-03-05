// Question: https://leetcode.com/problems/smallest-number-with-all-set-bits/description/

class SmallestNumberWithAllSetBits {
    public int smallestNumber(int n) {
        while (!isAllOneBits(n)) {
            n++;
        }
        return n;
    }

    private boolean isAllOneBits(int n) {
        while (n != 0) {
            if (n % 2 == 0) {
                return false;
            }
            n /= 2;
        }
        return true;
    }
}