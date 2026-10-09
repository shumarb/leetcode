// Question: https://leetcode.com/problems/happy-number/description/

class HappyNumber {
    public boolean isHappy(int n) {
        while (n > 0) {
            int sumOfSquareOfDigits = 0;

            while (n > 0) {
                sumOfSquareOfDigits += (int) Math.pow(n % 10, 2);
                n /= 10;
            }

            n = sumOfSquareOfDigits;
            if (n < 9) {
                break;
            }
        }

        return n == 1 || n == 7;
    }
}
