// Question: https://leetcode.com/problems/longer-contiguous-segments-of-ones-than-zeros/description/

class LongerContiguousSegmentsOfOnesThanZeros {
    public boolean checkZeroOnes(String s) {
        boolean isTest = false;
        int countConsecutiveZeroes = 0;
        int countConsecutiveOnes = 0;
        int current = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                current++;
            } else {
                countConsecutiveOnes = Math.max(current, countConsecutiveOnes);
                current = 0;
            }
        }
        countConsecutiveOnes = Math.max(current, countConsecutiveOnes);
        current = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                current++;
            } else {
                countConsecutiveZeroes = Math.max(current, countConsecutiveZeroes);
                current = 0;
            }
        }
        countConsecutiveZeroes = Math.max(current, countConsecutiveZeroes);
        if (isTest) {
            System.out.println("s: " + s + "\ncountConsecutiveOnes: " + countConsecutiveOnes);
            System.out.println("countConsecutiveZeroes: " + countConsecutiveZeroes);
        }

        return countConsecutiveOnes > countConsecutiveZeroes;
    }
}