// Question: https://leetcode.com/problems/rearrange-spaces-between-words/description/

class RearrangeSpacesBetweenWords {
    public String reorderSpaces(String text) {
        if (text.length() == 1) {
            return text;
        }
        String[] words = text.trim().split("\\s+");
        StringBuilder result = new StringBuilder();
        boolean isTest = false;
        int countSpace = 0;

        for (char c: text.toCharArray()) {
            if (c == ' ') {
                countSpace++;
            }
        }

        /**
         1.  Text contains 1 word and >= 1 space,
             so result comprises of the word followed by total number of spaces.
         */
        if (words.length == 1) {
            result.append(words[0]);
            for (int i = 0; i < countSpace; i++) {
                result.append(' ');
            }
            return result.toString();
        }

        /**
         2.  Compute number of spaces between each word,
             and number of spaces after last word.
         */
        int spacePerWord = countSpace / (words.length - 1);
        int remainingSpaces = countSpace % (words.length - 1);
        if (isTest) {
            System.out.println("text: " + text + "\ncountSpace: " + countSpace + "\nremainingSpaces: " + remainingSpaces);
            System.out.println("words: " + Arrays.toString(words) + " | countWords: " + words.length);
        }

        for (int i = 0; i < words.length; i++) {
            result.append(words[i]);
            if (i < words.length - 1) {
                for (int j = 0; j < spacePerWord; j++) {
                    result.append(' ');
                }
            }
        }
        for (int i = 0; i < remainingSpaces; i++) {
            result.append(' ');
        }
        if (isTest) {
            System.out.println("final result: " + result.toString());
        }

        return result.toString();
    }
}