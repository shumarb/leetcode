// Question: https://leetcode.com/problems/number-of-valid-words-in-a-sentence/description/

class NumberOfValidWordsInASentence {
    public int countValidWords(String sentence) {
        String[] tokens = sentence.trim().split("\\s+");
        boolean isTest = false;
        int countValid = 0;

        if (isTest) {
            System.out.println("sentence: " + sentence + "\ntokens: " + Arrays.toString(tokens));
        }
        for (String token: tokens) {
            if (isValid(token)) {
                if (isTest) {
                    System.out.println(" * valid: " + token);
                }
                countValid++;
            }
        }

        return countValid;
    }

    private boolean isValid(String token) {
        int countHyphen = 0;
        int countPunctuation = 0;
        int len = token.length();

        for (int i = 0; i < len; i++) {
            char c = token.charAt(i);

            if (Character.isDigit(c)) {
                return false;
            }

            if (c == '-') {
                countHyphen++;
                if (countHyphen > 1 || i == 0 || i == len - 1
                        || !Character.isLowerCase(token.charAt(i - 1))
                        || !Character.isLowerCase(token.charAt(i + 1))) {
                    return false;
                }
            }

            if (isPunctuation(c)) {
                countPunctuation++;
                if (i != len - 1 || countPunctuation > 1) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isPunctuation(char part) {
        return part == '!' || part == ',' || part == '.';
    }
}