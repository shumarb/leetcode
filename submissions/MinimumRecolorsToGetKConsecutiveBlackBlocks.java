// Question: https://leetcode.com/problems/minimum-recolors-to-get-k-consecutive-black-blocks/description/

class Solution {
    public int minimumRecolors(String blocks, int k) {
        int minimum = Integer.MAX_VALUE;
        int countW = 0;
        int countB = 0;
        int len = blocks.length();

        for (int i = 0; i < k; i++) {
            char letter = blocks.charAt(i);
            if (letter == 'B') {
                countB++;
            } else {
                countW++;
            }
        }
        minimum = Math.min(minimum, countW);

        for (int i = k; i < len; i++) {
            char remove = blocks.charAt(i - k);
            if (remove == 'W') {
                countW--;
            } else {
                countB--;
            }

            char incoming = blocks.charAt(i);
            if (incoming == 'W') {
                countW++;
            } else {
                countB++;
            }
            minimum = Math.min(minimum, countW);
        }

        return minimum;
    }
}