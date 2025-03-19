// Question: https://leetcode.com/problems/reverse-prefix-of-word/description/

class ReversePrefixOfWord {
    public String reversePrefix(String word, char ch) {
        int index = -1;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ch) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return word;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i <= index; i++) {
            result.append(word.charAt(i));
        }
        result = result.reverse();
        for (int i = index + 1; i < word.length(); i++) {
            result.append(word.charAt(i));
        }

        return result.toString();
    }
}