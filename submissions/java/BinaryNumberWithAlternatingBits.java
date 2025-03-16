// Question: https://leetcode.com/problems/binary-number-with-alternating-bits/description/

class BinaryNumberWithAlternatingBits {
    public boolean hasAlternatingBits(int n) {
        while (n != 0) {
            int currentBit = n % 2;
            n /= 2;
            int nextBit = n % 2;
            if (currentBit == nextBit) {
                return false;
            }
        }
        return true;
    }
}