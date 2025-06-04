// Question: https://leetcode.com/problems/first-letter-to-appear-twice/description/

class FirstLetterToAppearTwice {
    public char repeatedCharacter(String s) {
        boolean[] isLetterPresent = new boolean[26];

        for (char letter: s.toCharArray()) {
            if (isLetterPresent[letter - 'a']) {
                return letter;
            }
            isLetterPresent[letter - 'a'] = true;
        }

        return ' ';
    }
}