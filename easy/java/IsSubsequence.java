// Question: https://leetcode.com/problems/is-subsequence/description/

class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        boolean isTest = false;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (char letter: t.toCharArray()) {
            if (i < s.length() && letter == s.charAt(i)) {
                sb.append(letter);
                i++;
            }
        }
        if (isTest) {
            System.out.println("sb: " + sb.toString());
        }
        return sb.toString().equals(s);
    }
}