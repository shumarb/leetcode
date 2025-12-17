// Question: https://leetcode.com/problems/largest-number-after-digit-swaps-by-parity/description/

class LargestNumberAfterDigitSwapsByParity {
    public int largestInteger(int num) {
        boolean isTest = false;
        int[] digits = getDigits(num);
        int result = 0;

        if (isTest) {
            System.out.println("before, digits: " + Arrays.toString(digits));
        }
        for (int i = 0; i < digits.length; i++) {
            for (int j = i + 1; j < digits.length; j++) {
                if (digits[j] > digits[i] && (digits[j] - digits[i]) % 2 == 0) {
                    int temp = digits[j];
                    digits[j] = digits[i];
                    digits[i] = temp;
                }
            }
        }
        for (int i = 0; i < digits.length; i++) {
            result *= 10;
            result += digits[i];
        }
        if (isTest) {
            System.out.println("after, digits:  " + Arrays.toString(digits) + "\nresult: " + result);
        }

        return result;
    }

    private int[] getDigits(int n) {
        int[] digits;
        int j;
        int len = 0;
        int nCopy = n;

        while (nCopy != 0) {
            len++;
            nCopy /= 10;
        }
        digits = new int[len];
        j = len - 1;
        nCopy = n;

        while (j >= 0 && nCopy != 0) {
            digits[j--] = nCopy % 10;
            nCopy /= 10;
        }

        return digits;
    }
}