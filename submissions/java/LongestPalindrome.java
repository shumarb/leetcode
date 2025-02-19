// Question: https://leetcode.com/problems/longest-palindrome/description/

class LongestPalindrome {
    public int longestPalindrome(String s) {
        int[] letterFrequency = new int[52];
        boolean isTest = false;
        int longestPalindromeLength = 0;

        for (char letter: s.toCharArray()) {
            if (Character.isUpperCase(letter)) {
                letterFrequency[letter - 'A']++;
            } else {
                letterFrequency[letter - 'a' + 26]++;
            }
        }
        if (isTest) {
            System.out.println("s: " + s + "\nletterFrequency: " + Arrays.toString(letterFrequency));
        }

        boolean countAllOddLettersOnce = false;
        for (int count: letterFrequency) {
            if (count % 2 == 0) {
                // 1. If letter appears even number of times, all of it can be part of longest palindrome.
                longestPalindromeLength += count;
            } else {
                // 2. For letters appearing an odd number of times, add the count of one letter,
                // and for others, add count - 1.
                if (!countAllOddLettersOnce) {
                    longestPalindromeLength += count;
                    countAllOddLettersOnce = true;
                } else {
                    longestPalindromeLength += count - 1;
                }
            }
        }

        return longestPalindromeLength;
    }
}