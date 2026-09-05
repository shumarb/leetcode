// Question: https://leetcode.com/problems/number-of-even-and-odd-bits/description/

class NumberOfEvenAndOddBits {
    public int[] evenOddBit(int n) {
        boolean isEvenIndex = true;
        int[] result = new int[2];

        while (n > 0) {
            if (n % 2 == 1) {
                if (isEvenIndex) {
                    result[0]++;
                } else {
                    result[1]++;
                }
            }

            isEvenIndex = !isEvenIndex;
            n /= 2;
        }

        return result;
    }
}
