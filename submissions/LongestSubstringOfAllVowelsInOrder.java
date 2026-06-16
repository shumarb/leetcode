// Question: https://leetcode.com/problems/longest-substring-of-all-vowels-in-order/description/

class LongestSubstringOfAllVowelsInOrder {
    public int longestBeautifulSubstring(String word) {
        char[] letters = word.toCharArray();
        int current = 1;
        int countUniqueVowels = 1;
        int n = letters.length;
        int result = 0;

        if (n < 5) {
            return 0;
        }

        for (int i = 1; i < n; i++) {
            if (letters[i] == letters[i - 1]) {
                current++;

            } else if (letters[i] > letters[i - 1]) {
                countUniqueVowels++;
                current++;

            } else {
                countUniqueVowels = 1;
                current = 1;
            }

            if (countUniqueVowels == 5) {
                result = Math.max(current, result);
            }
        }

        return result;
    }
}
