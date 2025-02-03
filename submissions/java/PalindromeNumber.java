// Question: https://leetcode.com/problems/palindrome-number/description/

class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        char[] digits = String.valueOf(x).toCharArray();
        int l = 0;
        int r = digits.length - 1;
        while (l < r) {
            if (digits[l++] != digits[r--]) {
                return false;
            }
        }
        return true;
    }
}