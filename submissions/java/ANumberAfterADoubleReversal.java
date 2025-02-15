// Question: https://leetcode.com/problems/a-number-after-a-double-reversal/description/

class ANumberAfterADoubleReversal {
    public boolean isSameAfterReversals(int num) {
        int numCopy = num;
        boolean isTest = false;

        int reversed1 = getReversedNumber(numCopy);
        if (isTest) {
            System.out.println("num: " + num + "\nrevered1: " + reversed1);
        }

        int reversed2 = getReversedNumber(reversed1);
        if (isTest) {
            System.out.println("num: " + num + "\nrevered2: " + reversed2);
        }

        return reversed2 == num;
    }

    private int getReversedNumber(int num) {
        int reversedNumber = 0;

        // 1. Eliminate trailing zeroes
        while (num % 10 == 0 && num != 0) {
            num /= 10;
        }

        while (num != 0) {
            int digit = num % 10;
            reversedNumber = reversedNumber * 10 + digit;
            num /= 10;
        }

        return reversedNumber;
    }
}