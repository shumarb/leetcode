// Question: https://leetcode.com/problems/remove-palindromic-subsequences/description/

class RemovePalindromicSubsequences {
    public int removePalindromeSub(String s) {
        return isPalindrome(s.toCharArray()) ? 1 : 2;
    }

    private boolean isPalindrome(char[] letters) {
        int left = 0;
        int right = letters.length - 1;

        while (left < right) {
            if (letters[left++] != letters[right--]) {
                return false;
            }
        }

        return true;
    }
}
