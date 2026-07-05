// Question: https://leetcode.com/problems/sum-of-integers-with-maximum-digit-range/description/

class SumOfIntegersWithMaximumDigitRange {
    public int maxDigitRange(int[] nums) {
        boolean isTest = false;
        int maximumDigitRange = 0;
        int result = 0;

        for (int e: nums) {
            int digitRange = 0;
            int eCopy = e;
            int largestDigit = 0;
            int smallestDigit = 9;

            while (eCopy > 0) {
                int digit = eCopy % 10;
                largestDigit = Math.max(digit, largestDigit);
                smallestDigit = Math.min(digit, smallestDigit);
                eCopy /= 10;
            }

            digitRange = largestDigit - smallestDigit;
            if (isTest) {
                System.out.println("e: " + e + " | largestDigit: " + largestDigit + " | smallestDigit: " + smallestDigit + " | digitRange: " + digitRange);
            }

            if (digitRange > maximumDigitRange) {
                maximumDigitRange = digitRange;
                result = e;
            } else if (digitRange == maximumDigitRange) {
                result += e;
            }
        }
        if (isTest) {
            System.out.println("---------------------------------------------------------------\nresult: " + result);
        }

        return result;
    }
}
