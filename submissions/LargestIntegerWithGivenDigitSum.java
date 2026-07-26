// Question: https://leetcode.com/problems/largest-integer-with-given-digit-sum/description/

class LargestIntegerWithGivenDigitSum {
    public int largestInteger(int n, int s) {
        if (s == 0) {
            return 0;
        }

        boolean isTest = false;
        int largest = getLargest(n);
        int result = -1;

        if (isTest) {
            System.out.println("n: " + n + "\ns: " + s + "\nlimit: " + "\nrange: [1, " + largest + "]");
        }

        for (int i = largest; i >= 1; i--) {
            if (isValid(i, s)) {
                if (isTest) {
                    System.out.println("result: " + i);
                }

                return i;
            }
        }

        return result;
    }

    private boolean isValid(int number, int sumOfDigits) {
        int result = 0;

        while (number != 0) {
            result += number % 10;
            number /= 10;
        }

        return result == sumOfDigits;
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
