// Question: https://leetcode.com/problems/minimum-bit-flips-to-convert-number/description/

class MinimumBitFlipsToConvertNumber {
    public int minBitFlips(int start, int goal) {
        int count = 0;
        while (start != 0 || goal != 0) {
            if (start % 2 != goal % 2) {
                count++;
            }
            start /= 2;
            goal /= 2;
        }
        return count;
    }
}