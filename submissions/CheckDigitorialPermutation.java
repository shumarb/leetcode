// Question: https://leetcode.com/problems/check-digitorial-permutation/description/

class CheckDigitorialPermutation {
    public boolean isDigitorialPermutation(int n) {
        boolean isTest = false;
        int[] countDigits = new int[10];
        int[] factorial = new int[10];
        int sumOfDigitFactorials = 0;
        int value = n;

        factorial[0] = factorial[1] = 1;
        for (int i = 2; i < factorial.length; i++) {
            factorial[i] = i * factorial[i - 1];
        }
        while (value > 0) {
            int digit = value % 10;
            countDigits[digit]++;
            sumOfDigitFactorials += factorial[digit];
            value /= 10;
        }
        if (isTest) {
            System.out.println("n: " + n + "\nfactorial: " + Arrays.toString(factorial));
            System.out.println("countDigits: " + Arrays.toString(countDigits) + "\nsumOfDigitFactorials: " + sumOfDigitFactorials);
        }

        // 1. Valid permutation if all digits in sumOfDigitFactorials is equal to all digits in n.
        value = sumOfDigitFactorials;
        while (value > 0) {
            int digit = value % 10;
            countDigits[digit]--;
            value /= 10;
        }
        for (int i = 0; i < countDigits.length; i++) {
            if (countDigits[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
