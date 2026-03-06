// Question: https://leetcode.com/problems/check-if-binary-string-has-at-most-one-segment-of-ones/description/

class CheckIfBinaryStringHasAtMostOneSegmentOfOnes {
    public boolean checkOnesSegment(String s) {
        int countOneSegments = 0;
        int i = 0;
        int n = s.length();

        // 1. Find last index of 1 segment of 1's if any.
        while (i < n && s.charAt(i) == '1') {
            i++;
        }

        // 2. No 1's or entire string is 1's.
        if (i == 0 || i == n) {
            return true;
        }

        // 3. String has at least 1 segment of 1's
        // so if next 1 is encountered, a new segment of 1's is formed,
        // hence the string has > 1 segment of 1's.
        countOneSegments++;
        for (int j = i; j < n; j++) {
            if (s.charAt(j) == '1') {
                return false;
            }
        }

        return true;
    }
}