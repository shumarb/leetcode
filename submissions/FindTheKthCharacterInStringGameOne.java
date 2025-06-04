// Question: https://leetcode.com/problems/find-the-k-th-character-in-string-game-i/description/

class FindTheKthCharacterInStringGameOne {
    public char kthCharacter(int k) {
        boolean isTest = false;
        StringBuilder word = new StringBuilder();
        word.append('a');

        while (word.length() < k) {
            String generatedString = generatesString(word.toString());
            if (isTest) {
                System.out.println("before, word: " + word + "\ngenerated string: " + generatedString);
            }
            word.append(generatedString);
            if (isTest) {
                System.out.println("after, word: " + word);
                System.out.println("-----------------------------------------------------------------------------");
            }
        }
        if (isTest) {
            System.out.println("word: " + word);
        }

        return word.charAt(k - 1);
    }

    private String generatesString(String word) {
        StringBuilder result = new StringBuilder();
        for (char letter: word.toCharArray()) {
            result.append(getCorrectLetter(letter));
        }
        return result.toString();
    }

    private char getCorrectLetter(char letter) {
        if (letter == 'z') {
            return 'a';
        }
        return (char) (letter + 1);
    }
}