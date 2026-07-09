// Question: https://leetcode.com/problems/a-number-after-a-double-reversal/description/

class ANumberAfterADoubleReversal {
    public boolean isSameAfterReversals(int num) {
        boolean isTest = false;
        int reversed1 = getReversedNumber(num);
        int reversed2 = getReversedNumber(reversed1);

        if (isTest) {
            System.out.println("num: " + num + "\nreversed1: " + reversed1 + "\nreversed2: " + reversed2);
        }

        return reversed2 == num;
    }

    private int getReversedNumber(int num) {
        int result = 0;

        while (num > 0) {
            result = result * 10 + num % 10;
            num /= 10;
        }

        return result;
    }
}
