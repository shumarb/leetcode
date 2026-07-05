// Question: https://leetcode.com/problems/is-subsequence/description/

class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        char[] sLetters = s.toCharArray();
        char[] tLetters = t.toCharArray();
        int i = 0;
        int j = 0;
        int m = sLetters.length;

        while (i < m && j < tLetters.length) {
            if (sLetters[i] == tLetters[j]) {
                i++;
            }

            j++;
        }

        return i == m;
    }
}
