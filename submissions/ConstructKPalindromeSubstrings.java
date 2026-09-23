// Question: https://leetcode.com/problems/construct-k-palindrome-strings/description/

class ConstructKPalindromeSubstrings {
    public boolean canConstruct(String s, int k) {
        boolean isTest = false;
        int[] count = new int[26];
        int countOdd = 0;
        int n = s.length();

        if (k > n) {
            return false;
        }

        for (char c: s.toCharArray()) {
            count[c - 'a']++;
        }
        for (int e: count) {
            if ((e & 1) == 1) {
                countOdd++;
            }
        }

        return !(countOdd > k);
    }
}
