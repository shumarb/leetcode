// Question: https://leetcode.com/problems/finding-3-digit-even-numbers/description/

class Finding3DigitEvenNumber {
    private boolean isTest = false;

    public int[] findEvenNumbers(int[] digits) {
        List<Integer> even = new ArrayList<>();

        for (int i = 100; i <= 999; i++) {
            if (i % 2 == 0 && canBeFormed(i, digits)) {
                even.add(i);
            }
        }
        if (isTest) {
            System.out.println("digits: " + Arrays.toString(digits));
            System.out.println("even: " + even);
        }

        int[] result = new int[even.size()];
        int i = 0;
        for (int number: even) {
            result[i++] = number;
        }
        return result;
    }

    private boolean canBeFormed(int number, int[] digits) {
        int[] digitFrequency = new int[10];
        int[] numberDigitFrequency = new int[10];

        for (int digit: digits) {
            digitFrequency[digit]++;
        }

        int numberCopy = number;
        while (numberCopy != 0) {
            numberDigitFrequency[numberCopy % 10]++;
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