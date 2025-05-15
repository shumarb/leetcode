// Question: https://leetcode.com/problems/maximum-product-of-two-digits/description/

class MaximumProductOfTwoDigits {
    public int maxProduct(int n) {
        boolean isTest = false;
        int maxProduct = 0;
        int nCopy = n;
        int[] digitFrequency = new int[10];

        while (nCopy != 0) {
            digitFrequency[nCopy % 10]++;
            nCopy /= 10;
        }
        if (isTest) {
            System.out.println("n: " + n + "\ndigitFrequency: " + Arrays.toString(digitFrequency));
        }

        int largestDigit = -1;
        int secondLargestDigit = -1;
        for (int i = 9; i >= 0; i--) {
            if (digitFrequency[i]-- > 0) {
                largestDigit = i;
                break;
            }
        }
        for (int i = 9; i >= 0; i--) {
            if (digitFrequency[i]-- > 0) {
                secondLargestDigit = i;
                break;
            }
        }
        if (isTest) {
            System.out.println("largestDigit: " + largestDigit);
            System.out.println("secondLargestDigit: " + secondLargestDigit);
            System.out.println("product of aforementioned digits: " + (largestDigit * secondLargestDigit));
        }

        return largestDigit * secondLargestDigit;
    }
}