// Question: https://leetcode.com/problems/merge-strings-alternately/description/

class MergeStringsAlternately {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        int word1Pointer = 0;
        int word2Pointer = 0;

        while (word1Pointer < word1.length() && word2Pointer < word2.length()) {
            result.append(word1.charAt(word1Pointer++));
            result.append(word2.charAt(word2Pointer++));
        }
        if (word1Pointer < word1.length()) {
            addRemainingLetters(word1Pointer, word1, result);
        }
        if (word2Pointer < word2.length()) {
            addRemainingLetters(word2Pointer, word2, result);
        }

        return result.toString();
    }

    private void addRemainingLetters(int pointer, String word, StringBuilder result) {
        for (int i = pointer; i < word.length(); i++) {
            result.append(word.charAt(i));
        }
    }
}