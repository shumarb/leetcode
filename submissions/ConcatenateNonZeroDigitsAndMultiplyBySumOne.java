// Question: https://leetcode.com/problems/concatenate-non-zero-digits-and-multiply-by-sum-i/description/

class ConcatenateNonZeroDigitsAndMultiplyBySumOne {
    public long sumAndMultiply(int n) {
        boolean isTest = false;
        long number = 0;
        long sum = 0;
        long tens = 1;

        while (n > 0) {
            int digit = n % 10;
            if (digit > 0) {
                number += (tens * digit);
                sum += digit;
                tens *= 10;
            }
            n /= 10;
        }
        if (isTest) {
            System.out.println("number: " + number + "\nsum: " + sum);
        }

        return number * sum;
    }
}