// Question: https://leetcode.com/problems/check-if-word-equals-summation-of-two-words/description/

class CheckIfWordEqualsSummationOfTwoWords {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        boolean isTest = false;
        int firstValue = getValue(firstWord);
        int secondValue = getValue(secondWord);
        int targetValue = getValue(targetWord);

        if (isTest) {
            System.out.println("firstWord:  " + firstWord + " -> value: " + firstValue);
            System.out.println("secondWord: " + secondWord + " -> value: " + secondValue);
            System.out.println("targetWord: " + targetWord + " -> value: " + targetValue);
        }

        return firstValue + secondValue == targetValue;
    }

    private int getValue(String word) {
        char[] letters = word.toCharArray();
        int result = 0;

        for (int i = 0; i < letters.length; i++) {
            result *= 10;
            result += (int) (letters[i] - 'a');
        }

        return result;
    }
}
