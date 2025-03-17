// Question: https://leetcode.com/problems/check-whether-two-strings-are-almost-equivalent/description/

class CheckWhetherTwoStringsAreAlmostEquivalent {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        boolean isTest = false;
        int[] word1LetterFrequency = new int[26];
        int[] word2LetterFrequency = new int[26];

        for (char letter: word1.toCharArray()) {
            word1LetterFrequency[letter - 'a']++;
        }
        for (char letter: word2.toCharArray()) {
            word2LetterFrequency[letter - 'a']++;
        }
        if (isTest) {
            System.out.println("word1: " + word1 + "\nword1LetterFrequency: " + Arrays.toString(word1LetterFrequency));
            System.out.println("word2: " + word2 + "\nword2LetterFrequency: " + Arrays.toString(word2LetterFrequency));
        }

        for (int i = 0; i < 26; i++) {
            if (Math.abs(word2LetterFrequency[i] - word1LetterFrequency[i]) > 3) {
                return false;
            }
        }

        return true;
    }
}