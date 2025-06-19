// Question: https://leetcode.com/problems/find-special-substring-of-length-k/description/

class FindSpecialSubstringOfLengthK {
    public boolean hasSpecialSubstring(String s, int k) {
        int j = 0;
        int len = s.length();

        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == s.charAt(j)) {
                continue;
            }
            if (i - j == k) {
                return true;
            }
            j = i;
        }

        return (len - j) == k;
    }
}