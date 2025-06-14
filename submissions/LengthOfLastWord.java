// Question: https://leetcode.com/problems/length-of-last-word/description/

class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int count = 0;
        int i = s.length() - 1;

        while (i >= 0 && s.charAt(i) != ' ') {
            count++;
            i--;
        }

        return count;
    }
}