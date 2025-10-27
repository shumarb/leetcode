// Question: https://leetcode.com/problems/smallest-palindromic-rearrangement-i/description/

class SmallestPalindromicRearrangementOne {
    public String smallestPalindrome(String s) {
        int[] frequency = new int[26];
        int n = s.length();
        char[] left = s.substring(0, n / 2).toCharArray();

        Arrays.sort(left);
        String first = new String(left);
        String second = new StringBuilder(first).reverse().toString();
        for (char c: s.toCharArray()) {
            frequency[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (frequency[i] % 2 == 1) {
                return first + (char) ('a' + i) + second;
            }
        }

        return first + second;
    }
}