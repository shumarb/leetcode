// Question: https://leetcode.com/problems/minimum-recolors-to-get-k-consecutive-black-blocks/description/

class MinimumRecolorsToGetKConsecutiveBlackBlocks {
    public int minimumRecolors(String blocks, int k) {
        int countW = 0;
        int len = blocks.length();
        int minimumRecolors = Integer.MAX_VALUE;

        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') {
                countW++;
            }
        }
        minimumRecolors = Math.min(minimumRecolors, countW);
        for (int i = k; i < len; i++) {
            if (blocks.charAt(i - k) == 'W') {
                countW--;
            }
            if (blocks.charAt(i) == 'W') {
                countW++;
            }
            minimumRecolors = Math.min(minimumRecolors, countW);
        }

        return minimumRecolors;
    }
}