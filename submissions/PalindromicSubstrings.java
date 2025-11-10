// Question: https://leetcode.com/problems/palindromic-substrings/description/

class PalindromicSubstrings {
    private String s;
    private int n;
    private int result;

    public int countSubstrings(String s) {
        n = s.length();
        result = 0;
        this.s = s;

        for (int i = 0; i < n; i++) {
            // 1. Count palindromes where i-th character is center of odd-length palindrome.
            countPalindromes(i, i);

            // 2. Count palindromes where i-th & (i + 1)-th characters are center of even-length palindrome.
            countPalindromes(i, i + 1);
        }

        return result;
    }

    private void countPalindromes(int i, int j) {
        while (i >= 0 && j < n && s.charAt(i) == s.charAt(j)) {
            result++;
            i--;
            j++;
        }
    }
}