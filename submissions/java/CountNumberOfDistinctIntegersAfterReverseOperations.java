// Question: https://leetcode.com/problems/count-number-of-distinct-integers-after-reverse-operations/description/

class CountNumberOfDistinctIntegersAfterReverseOperations {
    public int countDistinctIntegers(int[] nums) {
        boolean[] isIntegerPresent = new boolean[10000001];
        int countDistinctIntegers = 0;

        for (int number: nums) {
            if (!isIntegerPresent[number]) {
                isIntegerPresent[number] = true;
                countDistinctIntegers++;
            }
            int numberReverse = computeReverseNumber(number);
            if (!isIntegerPresent[numberReverse]) {
                isIntegerPresent[numberReverse] = true;
                countDistinctIntegers++;
            }
        }

        return countDistinctIntegers;
    }

    private int computeReverseNumber(int number) {
        int reverseNumber = 0;
        while (number != 0) {
            reverseNumber *= 10;
            reverseNumber += number % 10;
            number /=10;
        }
        return reverseNumber;
    }
}