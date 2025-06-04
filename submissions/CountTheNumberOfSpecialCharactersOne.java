// Question: https://leetcode.com/problems/count-the-number-of-special-characters-i/description/

class CountTheNumberOfSpecialCharactersOne {
    public int numberOfSpecialChars(String word) {
        boolean[] isLowerCaseLetterPresent = new boolean[26];
        boolean[] isUpperCaseLetterPresent = new boolean[26];
        int countSpecialCharacters = 0;
        boolean isTest = false;

        for (char letter: word.toCharArray()) {
            if (Character.isUpperCase(letter)) {
                isUpperCaseLetterPresent[letter - 'A'] = true;
            } else if (Character.isLowerCase(letter)) {
                isLowerCaseLetterPresent[letter - 'a'] = true;
            }
        }
        if (isTest) {
            System.out.println("word: " + word);
            System.out.println("isUpperCaseLetterPresent: " + Arrays.toString(isUpperCaseLetterPresent));
            System.out.println("isLowerCaseLetterPresent: " + Arrays.toString(isLowerCaseLetterPresent));
        }

        for (int i = 0; i < 26; i++) {
            if (isUpperCaseLetterPresent[i] && isLowerCaseLetterPresent[i]) {
                countSpecialCharacters++;
            }
        }

        return countSpecialCharacters;
    }
}