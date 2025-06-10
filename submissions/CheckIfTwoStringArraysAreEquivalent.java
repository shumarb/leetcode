// Question: https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/description/

class CheckIfTwoStringArraysAreEquivalent {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        boolean isTest = false;
        String word1Sb = update(word1);
        String word2Sb = update(word2);
        if (isTest) {
            System.out.println("word1: " + Arrays.toString(word1) + " | word1Sb: " + word1Sb);
            System.out.println("word2: " + Arrays.toString(word2) + " | word2Sb: " + word2Sb);
        }

        return word1Sb.equals(word2Sb);
    }

    private String update(String[] words) {
        StringBuilder result = new StringBuilder();
        for (String word: words) {
            result.append(word);
        }
        return result.toString();
    }
}