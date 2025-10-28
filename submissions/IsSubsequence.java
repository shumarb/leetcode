// Question: https://leetcode.com/problems/is-subsequence/description/

class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;
        int n = s.length();

        while (i < n && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }

        return i == n;
    }
}