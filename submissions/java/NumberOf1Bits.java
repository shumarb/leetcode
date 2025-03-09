// Question: https://leetcode.com/problems/number-of-1-bits/description/

class NumberOf1Bits {
    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }
}