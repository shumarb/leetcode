// Question: https://leetcode.com/problems/check-if-binary-string-has-at-most-one-segment-of-ones/description/

class CheckIfBinaryStringHasAtMostOneSegmentOfOnes {
    public boolean checkOnesSegment(String s) {
        boolean isTest = false;
        int countOnesSegment = 0;
        int currentLength = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                currentLength++;
            } else {
                if (currentLength > 0) {
                    countOnesSegment++;
                }
                currentLength = 0;
            }
        }
        if (currentLength > 0) {
            countOnesSegment++;
        }
        if (isTest) {
            System.out.println("s: " + s + "\ncountOnesSegment: " + countOnesSegment);
        }

        return countOnesSegment == 1;
    }
}