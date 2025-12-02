// Question: https://leetcode.com/problems/concatenate-non-zero-digits-and-multiply-by-sum-i/description/

class Solution {
    public long sumAndMultiply(int n) {
        boolean isTest = false;
        long numberReverse = 0;
        long number = 0;
        long sum = 0;

        while (n > 0) {
            int digit = n % 10;
            if (digit > 0) {
                numberReverse *= 10;
                numberReverse += digit;
                sum += digit;
            }
            n /= 10;
        }
        while (numberReverse > 0) {
            number *= 10;
            number += numberReverse % 10;
            numberReverse /= 10;
        }
        if (isTest) {
            System.out.println("number: " + number + "\nsum: " + sum);
        }

        return number * sum;
    }
}