// Question: https://leetcode.com/problems/check-if-word-equals-summation-of-two-words/description/

class CheckIfWordEqualsSummationOfTwoWords {
    private boolean isTest = false;

    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        int firstWordNumericalValue = computeValue(firstWord);
        int secondWordNumericalValue = computeValue(secondWord);
        int targetWordNumericalValue = computeValue(targetWord);
        if (isTest) {
            System.out.println("firstWord: " + firstWord + " --> " + firstWordNumericalValue);
            System.out.println("secondWord: " + secondWord + " --> " + secondWordNumericalValue);
            System.out.println("targetWord: " + targetWord + " --> " + targetWordNumericalValue);
        }

        return (firstWordNumericalValue + secondWordNumericalValue) == targetWordNumericalValue;
    }

    private int computeValue(String word) {
        StringBuilder number = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            int digit = word.charAt(i) - 'a';
            number.append(digit);
        }

        int firstNoZeroIndex = 0;
        while (firstNoZeroIndex < number.length() && number.charAt(firstNoZeroIndex) == '0') {
            firstNoZeroIndex++;
        }
        if (isTest) {
            System.out.println("word: " + word + " --> " + number);
            System.out.println(" * firstNoZeroIndex: " + firstNoZeroIndex);
        }
        if (firstNoZeroIndex == number.length()) {
            return 0;
        }

        int value = 0;
        for (int i = firstNoZeroIndex; i < number.length(); i++) {
            value *= 10;
            value += number.charAt(i) - '0';
        }
        if (isTest) {
            System.out.println(" * value: " + value);
        }

        return value;
    }
}