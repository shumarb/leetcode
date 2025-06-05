// Question: https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/description/

class FindWordsThatCanBeFormedByCharacters {
    public int countCharacters(String[] words, String chars) {
        int count = 0;
        int[] charFrequency = countLetters(chars);
        for (String word: words) {
            int[] wordLetterFrequency = countLetters(word);
            if (isValid(wordLetterFrequency, charFrequency)) {
                count += word.length();
            }
        }
        return count;
    }

    private boolean isValid(int[] wordFrequency, int[] charsFrequency) {
        for (int i = 0; i < 26; i++) {
            if (charsFrequency[i] < wordFrequency[i]) {
                return false;
            }
        }
        return true;
    }

    private int[] countLetters(String str) {
        int[] letterFrequency = new int[26];
        for (char letter: str.toCharArray()) {
            letterFrequency[letter - 'a']++;
        }
        return letterFrequency;
    }
}