// Question: https://leetcode.com/problems/maximum-product-of-two-digits/description/

class MaximumProductOfTwoDigits {
    public int maxProduct(int n) {
        boolean isTest = false;
        int largestDigit = -1;
        int secondLargestDigit = -1;
        int nCopy = n;

        while (nCopy != 0) {
            int digit = nCopy % 10;
            if (digit > largestDigit) {
                secondLargestDigit = largestDigit;
                largestDigit = digit;
            } else if (digit > secondLargestDigit) {
                secondLargestDigit = digit;
            }
            nCopy /= 10;
        }
        if (isTest) {
            System.out.println("n: " + n + "\nlargestDigit: " + largestDigit);
            System.out.println("secondLargestDigit: " + secondLargestDigit + "\nmaximum product: " + (largestDigit * secondLargestDigit));
        }

        return largestDigit * secondLargestDigit;
    }
}