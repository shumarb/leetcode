// Question: https://leetcode.com/problems/largest-substring-between-two-equal-characters/description/

class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] first = new int[26];
        int[] last = new int[26];
        boolean isTest = false;
        int maxLengthBetweenEqualCharacters = -1;

        Arrays.fill(first, -1);
        Arrays.fill(last, -1);
        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            if (first[letter - 'a'] == -1) {
                first[letter - 'a'] = i;
            }
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            char letter = s.charAt(i);
            if (last[letter - 'a'] == -1) {
                last[letter - 'a'] = i;
            }
        }
        if (isTest) {
            System.out.println("s: " + s + "\nfirst: " + Arrays.toString(first));
            System.out.println("last: " + Arrays.toString(last) + "\nmaxLengthBetweenEqualCharacters: " + maxLengthBetweenEqualCharacters);
        }

        for (int i = 0; i < 26; i++) {
            if (first[i] != -1 && last[i] != -1) {
                maxLengthBetweenEqualCharacters = Math.max(maxLengthBetweenEqualCharacters, last[i] - first[i] - 1);
            }
        }

        return maxLengthBetweenEqualCharacters;
    }
}