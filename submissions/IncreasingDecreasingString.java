// Question: https://leetcode.com/problems/increasing-decreasing-string/description/

class IncreasingDecreasingString {
    public String sortString(String s) {
        StringBuilder result = new StringBuilder();
        int[] count = new int[26];

        for (char c: s.toCharArray()) {
            count[c - 'a']++;
        }

        while (result.length() < s.length()) {
            for (int i = 0; i < 26; i++) {
                if (count[i] > 0) {
                    result.append((char) ('a' + i));
                    count[i]--;
                }
            }

            for (int i = 25; i >= 0; i--) {
                if (count[i] > 0) {
                    result.append((char) ('a' + i));
                    count[i]--;
                }
            }
        }

        return result.toString();
    }
}