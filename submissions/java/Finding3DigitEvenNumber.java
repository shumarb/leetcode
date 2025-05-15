// Question: https://leetcode.com/problems/finding-3-digit-even-numbers/description/

class Finding3DigitEvenNumber {
    private boolean isTest = false;

    public int[] findEvenNumbers(int[] digits) {
        List<Integer> even = new ArrayList<>();
        int[] digitFrequency = new int[10];
        for (int digit: digits) {
            digitFrequency[digit]++;
        }

        for (int i = 100; i <= 998; i += 2) {
            if (canBeFormed(i, digitFrequency)) {
                even.add(i);
            }
        }
        if (isTest) {
            System.out.println("digits: " + Arrays.toString(digits));
            System.out.println("digitFrequency: " + Arrays.toString(digitFrequency));
            System.out.println("even: " + even);
        }

        int[] result = new int[even.size()];
        int i = 0;
        for (int number: even) {
            result[i++] = number;
        }

        return result;
    }

    private boolean canBeFormed(int number, int[] digitFrequency) {
        int[] numberDigitFrequency = new int[10];
        int numberCopy = number;

        while (numberCopy != 0) {
            int digit = numberCopy % 10;

            /**
             1. Digit in number is not in digits array,
             so number can't be formed from digits.
             */
            if (digitFrequency[digit] == 0) {
                return false;
            }
            numberDigitFrequency[digit]++;
            numberCopy /= 10;
        }
        if (isTest) {
            System.out.println("number: " + number);
            System.out.println("numberDigitFrequency:   " + Arrays.toString(numberDigitFrequency));
            System.out.println("digitFrequency:         " + Arrays.toString(digitFrequency));
            System.out.println("-------------------------------------------------------------------");
        }

        for (int i = 0; i < 10; i++) {
            if (digitFrequency[i] < numberDigitFrequency[i]) {
                return false;
            }
        }

        return true;
    }
}