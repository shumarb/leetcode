// Question: https://leetcode.com/problems/smallest-palindromic-rearrangement-i/description/

class SmallestPalindromicRearrangementOne {
    public String smallestPalindrome(String s) {
        int[] frequency = new int[26];
        int n = s.length();
        char oddLetter = 'X';
        char[] left = s.substring(0, n / 2).toCharArray();

        for (char c: s.toCharArray()) {
            frequency[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (frequency[i] % 2 == 1) {
                oddLetter = (char)('a' + i);
                break;
            }
        }
        Arrays.sort(left);
        String first = new String(left);
        String second = new StringBuilder(first).reverse().toString();

        return oddLetter == 'X' ? first + second : first + oddLetter + second;
    }
}
