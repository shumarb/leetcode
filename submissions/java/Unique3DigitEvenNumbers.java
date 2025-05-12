// Question: https://leetcode.com/problems/unique-3-digit-even-numbers/description/

class Unique3DigitEvenNumbers {
    private boolean isTest = false;

    public int totalNumbers(int[] digits) {
        int count = 0;
        int[] digitFrequency = new int[10];

        for (int digit: digits) {
            digitFrequency[digit]++;
        }
        if (isTest) {
            System.out.println("digits: " + Arrays.toString(digits));
            System.out.println("digitFrequency: " + Arrays.toString(digitFrequency));
        }

        for (int i = 100; i <= 998; i += 2) {
            if (isValidNumber(i, digitFrequency)) {
                count++;
            }
        }

        return count;
    }

    private boolean isValidNumber(int number, int[] digitFrequency) {
        int[] numberFrequency = new int[10];
        int n = number;
        while (n != 0) {
            numberFrequency[n % 10]++;
            n /= 10;
        }
        if (isTest) {
            System.out.println("number: " + number + "\nnumberFrequency: " + Arrays.toString(numberFrequency));
            System.out.println("digitFrequency: " + Arrays.toString(digitFrequency));
            System.out.println("-------------------------------------------------------------------------------------");
        }
        for (int i = 0; i < 10; i++) {
            if (numberFrequency[i] > digitFrequency[i]) {
                return false;
            }
        }
        return true;
    }
}