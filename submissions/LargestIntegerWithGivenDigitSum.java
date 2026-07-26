// Question: https://leetcode.com/problems/largest-integer-with-given-digit-sum/description/

class LargestIntegerWithGivenDigitSum class Solution {
    public int largestInteger(int n, int s) {
        if (s == 0) {
            return 0;
        }

        boolean isTest = false;
        int largest = getLargest(n);
        int largestSingleDigit = Math.min(9, largest);
        int result = -1;
        int[] sum = new int[largest + 1];

        for (int i = 1; i <= largestSingleDigit; i++) {
            sum[i] = i;
        }
        for (int i = 10; i <= largest; i++) {
            sum[i] = sum[i / 10] + i % 10;
        }
        if (isTest) {
            System.out.println("n: " + n + "\ns: " + s + "\nnumber range: [1, " + largest + "]" + "\nsum: " + Arrays.toString(sum));
        }

        for (int i = largest; i >= 1; i--) {
            if (sum[i] == s) {
                if (isTest) {
                    System.out.println("---------------------\nresult: " + i);
                }

                return i;
            }
        }

        return result;
    }

    private int getLargest(int n) {
        if (n == 2) {
            return 99;

        } else if (n == 3) {
            return 999;

        } else if (n == 4) {
            return 9999;

        } else if (n == 5) {
            return 99999;

        } else {
            return 9;
        }
    }
}
