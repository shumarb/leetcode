// Question: https://leetcode.com/problems/longer-contiguous-segments-of-ones-than-zeros/description/

class LongerContiguousSegmentsOfOnesThanZeros {
    public boolean checkZeroOnes(String s) {
        boolean isTest = false;
        int longestOnes = getLongestConsecutive(s, '1');
        int longestZeros = getLongestConsecutive(s, '0');

        if (isTest) {
            System.out.println("s: " + s);
            System.out.println("longestOnes: " + longestOnes + "\nlongestZeros: " + longestZeros);
        }

        return longestOnes > longestZeros;
    }

    private int getLongestConsecutive(String s, char c) {
        int currentLength = 0;
        int maximumLength = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                currentLength++;
            } else {
                maximumLength = Math.max(maximumLength, currentLength);
                currentLength = 0;
            }
        }

        return Math.max(maximumLength, currentLength);
    }
}