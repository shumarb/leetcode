// Question: https://leetcode.com/problems/maximum-number-of-words-you-can-type/description/

class MaximumNumberOfWordsYouCanType {
    public int canBeTypedWords(String text, String brokenLetters) {
        boolean isTest = false;
        boolean[] isBrokenLetter = new boolean[26];
        int countTypedWords = 0;

        for (char letter: brokenLetters.toCharArray()) {
            isBrokenLetter[letter - 'a'] = true;
        }
        if (isTest) {
            System.out.println("text: " + text + "\nbrokenLetters: " + brokenLetters + "\nisBrokenLetter: " + Arrays.toString(isBrokenLetter));
        }

        for (String word: text.split(" ")) {
            if (canWordBeTyped(word, isBrokenLetter)) {
                if (isTest) {
                    System.out.println(" * can be typed: " + word);
                }
                countTypedWords++;
            }
        }
        if (isTest) {
            System.out.println("count typed words: " + countTypedWords);
        }

        return countTypedWords;
    }

    private boolean canWordBeTyped(String word, boolean[] isBrokenLetter) {
        for (char letter: word.toCharArray()) {
            if (isBrokenLetter[letter - 'a']) {
                return false;
            }
        }
        return true;
    }
}