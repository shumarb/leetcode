// Question: https://leetcode.com/problems/check-if-string-is-a-prefix-of-array/description/

class CheckIfStringIsAPrefixOfArray {
    public boolean isPrefixString(String s, String[] words) {
        StringBuilder formedWord = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            formedWord.append(words[i]);
            if (formedWord.toString().equals(s)) {
                return true;
            }
        }
        return false;
    }
}