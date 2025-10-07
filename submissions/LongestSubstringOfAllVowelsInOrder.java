// Question: https://leetcode.com/problems/longest-substring-of-all-vowels-in-order/description/

class LongestSubstringOfAllVowelsInOrder {
    public int longestBeautifulSubstring(String word) {
        // 1. Edge case: word has insufficient characters.
        if (word.length() < 5) {
            return 0;
        }

        int count = 1;
        int current = 1;
        int longest = 0;
        int n = word.length();

        for (int i = 1; i < n; i++) {
            if (word.charAt(i) == word.charAt(i - 1)) {
                current++;

            } else if (word.charAt(i) > word.charAt(i - 1)) {
                count++;
                current++;

            } else {
                count = 1;
                current = 1;
            }

            if (count == 5) {
                longest = Math.max(current, longest);
            }
        }

        return longest;
    }
}