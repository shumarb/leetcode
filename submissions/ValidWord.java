// Question: https://leetcode.com/problems/valid-word/description/

class ValidWord {
    public boolean isValid(String word) {
        if (word.length() < 3) {
            return false;
        }
        boolean isTest = false;

        int countVowel = 0;
        int countConsonant = 0;
        for (char c: word.toCharArray()) {
            if (isTest) {
                System.out.println("c: " + c);
            }

            if (!Character.isLetterOrDigit(c)) {
                return false;
            } else if (Character.isLetter(c) && isVowel(c)) {
                countVowel++;
            } else if (Character.isLetter(c) && !isVowel(c)) {
                countConsonant++;
            }
        }
        if (isTest) {
            System.out.println("word: " + word + "\ncountVowel: " + countVowel + ", countConsonant: " + countConsonant);
        }

        return countVowel >= 1 && countConsonant >= 1;
    }

    private boolean isVowel(char letter) {
        return letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u'
                || letter == 'A' || letter == 'E' || letter == 'I' || letter == 'O' || letter == 'U';
    }
}