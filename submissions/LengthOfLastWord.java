// Question: https://leetcode.com/problems/length-of-last-word/description/

class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        boolean isTest = false;
        String[] words = s.split(" ");
        if (isTest) {
            System.out.println("s: " + s + "\nwords: " + Arrays.toString(words));
        }
        return words[words.length - 1].length();
    }
}