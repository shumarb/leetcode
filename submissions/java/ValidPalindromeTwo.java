// Question:

class ValidPalindromeTwo {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                /**
                 1.  If either letter at indices left of right is removed, a valid palindrome could be formed
                 Form two new words without letter at indices left or right,
                 and if either one is a palindrome, then s is a valid palindrome.
                 */
                return isPalindrome(s, left, right - 1) || isPalindrome(s, left + 1, right);
            }
        }
        return true;
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}