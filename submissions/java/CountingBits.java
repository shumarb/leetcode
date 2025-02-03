// Question: https://leetcode.com/problems/counting-bits/description/

class CountingBits {
    public int[] countBits(int n) {
        int[] numOneBits = new int[n + 1];
        for (int i = 1; i < numOneBits.length; i++) {
            numOneBits[i] = getNumberOfOnes(i);
        }
        return numOneBits;
    }

    private int getNumberOfOnes(int num) {
        int count = 0;
        while (num != 0) {
            if ((num % 2) == 1) {
                count++;
            }
            num /= 2;
        }
        return count;
    }
}