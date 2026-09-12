// Question: https://leetcode.com/problems/check-if-numbers-are-ascending-in-a-sentence/description/

class CheckIfNumbersAreAscendingInASentence {
    public boolean areNumbersAscending(String s) {
        String[] words = s.split(" ");
        int previousNumber = Integer.MIN_VALUE;

        for (String word: words) {
            if (Character.isDigit(word.charAt(0))) {
                int currentNumber = Integer.parseInt(word);

                // 1. Non-ascending order from previous number to current number found.
                if (currentNumber <= previousNumber) {
                    return false;
                }

                // 2. Set previous number as current number for comparison with next number.
                previousNumber = currentNumber;
            }
        }

        return true;
    }
}
