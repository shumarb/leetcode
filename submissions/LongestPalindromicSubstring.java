// Question: https://leetcode.com/problems/longest-palindromic-substring/description/

class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        String longest = "";
        String result = s;
        int n = s.length();

        if (n == 1) {
            return s;
        }

        for (int i = 0; i < n; i++) {
            /**
             1.  Check for odd-length (i-th letter is the middle letter)
             & even-length palindrome (i-th & (i + 1)-th letters are the same and form middle letters).
             */
            String odd = getPalindrome(s, i, i);
            String even = getPalindrome(s, i, i + 1);
            String current = odd.length() > even.length() ? odd : even;

            if (current.length() > longest.length()) {
                longest = current;
            }
        }

        return longest;
    }

    private String getPalindrome(String s, int left, int right) {
        int n = s.length();

        while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return s.substring(left + 1, right);
    }
}