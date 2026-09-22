// Question: https://leetcode.com/problems/remove-palindromic-subsequences/description/

class RemovePalindromicSubsequences {
    public int removePalindromeSub(String s) {
        char[] letters = s.toCharArray();
        int left = 0;
        int right = letters.length - 1;

        while (left < right) {
            if (letters[left++] != letters[right--]) {
                /**
                 1.  Given string is not a palindrome, and there are only 2 characters,
                     remove all letters of the first letter (1 step), then all letters of the second letter (1 step),
                     hence 2 steps are neded to convert s to an empty string.
                 */
                return 2;
            }
        }

        /**
            2. String is a palindrome, so remove all its characters to get an empty string.
         */
        return 1;
    }
}
