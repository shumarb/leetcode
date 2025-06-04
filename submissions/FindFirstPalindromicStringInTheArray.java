// Question: https://leetcode.com/problems/find-first-palindromic-string-in-the-array/description/

class FindFirstPalindromicStringInAnArray {
    public String firstPalindrome(String[] words) {
        for (String word: words) {
            if (isPalindrome(word)) {
                return word;
            }
        }
        return "";
    }

    private boolean isPalindrome(String word) {
        int left = 0;
        int right = word.length() - 1;
        while (left < right) {
            if (word.charAt(left++) != word.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}