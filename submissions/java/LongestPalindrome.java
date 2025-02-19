// Question: https://leetcode.com/problems/longest-palindrome/description/

class LongestPalindrome {
    public int longestPalindrome(String s) {
        int longestPalindromeLength = 0;
        boolean isTest = false;
        Map<Character, Integer> map = new HashMap<>();

        for (char letter: s.toCharArray()) {
            map.put(letter, 1 + map.getOrDefault(letter, 0));
        }
        if (isTest) {
            System.out.println("s: " + s + "\nmap: " + map);
        }

        int countOddNumberOfLetters = 0;
        for (Map.Entry<Character, Integer> entry: map.entrySet()) {
            // 1. If letter appears even number of times, all of it can be part of longest palindrome
            if (entry.getValue() % 2 == 0) {
                longestPalindromeLength += entry.getValue();
            } else {
                // 2. For letters appearing odd numbers, can add total number of times it appears exactly once,
                // and for the rest, can only add its total - 1.
                if (countOddNumberOfLetters == 0) {
                    longestPalindromeLength += entry.getValue();
                } else {
                    longestPalindromeLength += entry.getValue() - 1;
                }
                countOddNumberOfLetters++;
            }
        }

        return longestPalindromeLength;
    }
}