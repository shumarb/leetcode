// Question: https://leetcode.com/problems/maximum-69-number/description/

class Maximum69Number {
    public int maximum69Number (int num) {
        int numCopy = num;
        int count = 0;
        boolean isAllNine = true;

        while (numCopy != 0) {
            count++;
            if (numCopy % 10 != 9) {
                isAllNine = false;
            }
            numCopy /= 10;
        }

        // 1. All digits are 9, so num is maximum 69 number.
        if (isAllNine) {
            return num;
        }

        numCopy = num;
        boolean isTest = false;
        int[] digits = new int[count];
        int j = count - 1;
        while (numCopy != 0) {
            digits[j--] = numCopy % 10;
            numCopy /= 10;
        }
        if (isTest) {
            System.out.println("num: " + num + "\ndigits: " + Arrays.toString(digits));
        }

        int maximum = num;
        for (int i = 0; i < digits.length; i++) {
            int[] digitsCopy = Arrays.copyOf(digits, digits.length);
            if (digitsCopy[i] == 6) {
                digitsCopy[i] = 9;
                if (isTest) {
                    System.out.println(" * compare: " + maximum + ", " + formsNumber(digitsCopy));
                }
                maximum = Math.max(maximum, formsNumber(digitsCopy));
            }
        }

        return maximum;
    }

    private int formsNumber(int[] digits) {
        int number = 0;
        for (int digit: digits) {
            number *= 10;
            number += digit;
        }
        return number;
    }
}