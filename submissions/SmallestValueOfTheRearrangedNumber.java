// Question: https://leetcode.com/problems/smallest-value-of-the-rearranged-number/description/

class SmallestValueOfTheRearrangedNumber {
    public long smallestNumber(long num) {
        // 1. Edge case: Single-digit number.
        if (num >= -9 && num <= 9) {
            return num;
        }

        boolean isTest = false;
        int[] digitFrequency = new int[10];
        long numCopy = num;
        long result = 0;

        if (num < 0) {
            numCopy *= -1;
        }
        while (numCopy != 0) {
            digitFrequency[(int) (numCopy % 10)]++;
            numCopy /= 10;
        }
        if (isTest) {
            System.out.println("num: " + num);
            System.out.println("digitFrequency: " + Arrays.toString(digitFrequency));
        }

        if (num < 0) {
            for (int i = 9; i >= 1; i--) {
                if (digitFrequency[i]-- > 0) {
                    result = i;
                    break;
                }
            }
            for (int i = 9; i >= 0; i--) {
                while (digitFrequency[i]-- > 0) {
                    result *= 10;
                    result += i;
                }
            }
            result *= -1;
        } else {
            for (int i = 1; i <= 9; i++) {
                if (digitFrequency[i]-- > 0) {
                    result = i;
                    break;
                }
            }
            for (int i = 0; i <= 9; i++) {
                while (digitFrequency[i]-- > 0) {
                    result *= 10;
                    result += i;
                }
            }
        }

        if (isTest) {
            System.out.println("result: " + result);
        }

        return result;
    }
}