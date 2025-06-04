// Question: https://leetcode.com/problems/remove-letter-to-equalize-frequency/description/

class RemoveLetterToEqualizeFrequency {
    public boolean equalFrequency(String word) {
        for (int i = 0; i < word.length(); i++) {
            String newWord = formsNewWord(word, i);
            if (isValidNewWord(newWord)) {
                return true;
            }
        }
        return false;
    }

    private boolean isValidNewWord(String word) {
        int value = 0;
        int[] letterFrequency = new int[26];
        for (char letter: word.toCharArray()) {
            letterFrequency[letter - 'a']++;
            value = letterFrequency[letter - 'a'];
        }

        for (int number: letterFrequency) {
            if (number > 0 && number != value) {
                return false;
            }
        }
        return true;
    }

    private String formsNewWord(String word, int indexToAvoid) {
        StringBuilder newWord = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (i != indexToAvoid) {
                newWord.append(word.charAt(i));
            }
        }
        return newWord.toString();
    }
}