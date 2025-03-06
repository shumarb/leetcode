// Question: https://leetcode.com/problems/repeated-substring-pattern/description/

class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        /**
         1.  Form a string of s concatenated with itself.
         Next, check if s is in the substring formed earlier without its first and last characters.
         */
        String doubled = s + s;
        return doubled.substring(1, doubled.length() - 1).contains(s);
    }
}