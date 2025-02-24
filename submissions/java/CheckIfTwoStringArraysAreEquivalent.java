// Question: https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/description/

class CheckIfTwoStringArraysAreEquivalent {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        return update(word1).equals(update(word2));
    }

    private String update(String[] words) {
        StringBuilder result = new StringBuilder();
        for (String word: words) {
            for (char letter: word.toCharArray()) {
                result.append(letter);
            }
        }
        return result.toString();
    }
}