// Question: https://leetcode.com/problems/length-of-the-longest-alphabetical-continuous-substring/description/

class LengthOfTheLongestAlphabeticalContinuousSubstring {
    public int longestContinuousSubstring(String s) {
        // 1. Edge case: s has 1 character.
        if (s.length() == 1) {
            return 1;
        }

        boolean isTest = false;
        int i = 0;
        int j = 0;
        int len = s.length();
        int longest = 1; // 2. Worst-case scenario, s comprises of non-consecutive letters.

        for (i = 0; i < len - 1; ) {
            if (s.charAt(i + 1) - s.charAt(i) != 1) {
                i++;
            } else {
                j = i + 1;
                while (j < len && s.charAt(j) - s.charAt(j - 1) == 1) {
                    j++;
                }
                if (isTest) {
                    System.out.println(" * valid found | i: " + i + ", j: " + j + " | length: " + (j - i));
                }
                longest = Math.max(longest, j - i);
                i = j;
            }
        }
        if (j - i > 0) {
            if (isTest) {
                System.out.println(" * valid found | i: " + i + ", j: " + j + " | length: " + (j - i));
            }
        }

        return Math.max(longest, j - i);
    }
}