// Question: https://leetcode.com/problems/palindromic-substrings/description/

class PalindromicSubstrings {
    private char[] letters;
    private int n;
    private int result;

    public int countSubstrings(String s) {
        letters = s.toCharArray();
        n = letters.length;
        result = 0;

        for (int i = 0; i < n; i++) {
            countPalindromes(i, i);
            countPalindromes(i, i + 1);
        }

        return result;
    }

    private void countPalindromes(int left, int right) {
        while (left >= 0 && right < n && letters[left--] == letters[right++]) {
            result++;
        }
    }
}
