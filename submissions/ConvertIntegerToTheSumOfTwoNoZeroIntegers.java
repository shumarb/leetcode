// Question: https://leetcode.com/problems/convert-integer-to-the-sum-of-two-no-zero-integers/description/

class ConvertIntegerToTheSumOfTwoNoZeroIntegers {
    public int[] getNoZeroIntegers(int n) {
        for (int i = 1; i <= n; i++) {
            if (!containsZero(i) && !containsZero(n - i)) {
                return new int[] {i, n - i};
            }
        }
        return null;
    }

    private boolean containsZero(int num) {
        while (num != 0) {
            if (num % 10 == 0) {
                return true;
            }
            num /= 10;
        }
        return false;
    }
}