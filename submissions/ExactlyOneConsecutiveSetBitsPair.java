// Question: https://leetcode.com/problems/exactly-one-consecutive-set-bits-pair/description/

class ExactlyOneConsecutiveSetBitsPair {
    public boolean consecutiveSetBits(int n) {
        int countConsecutiveSetBits = 0;
        int last = -1;

        while (n > 0) {
            int bit = n % 2;
            if (last == 1 && bit == 1 && ++countConsecutiveSetBits > 1) {
                return false;
            }
            last = bit;
            n /= 2;
        }

        return countConsecutiveSetBits == 1;
    }
}
