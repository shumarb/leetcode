// Question: https://leetcode.com/problems/minimum-sum-of-four-digit-number-after-splitting-digits/description/

class MinimumSumOfFourDigitNumberAfterSplittingDigits {
    public int minimumSum(int num) {
        int[] frequency = new int[10];
        boolean isNum1 = true;
        boolean isTest = false;
        int count = 0;
        int numCopy = num;
        int num1 = 0;
        int num2 = 0;

        while (numCopy > 0) {
            frequency[numCopy % 10]++;
            numCopy /= 10;
        }
        if (isTest) {
            System.out.println("before, frequency: " + Arrays.toString(frequency));
        }

        for (int i = 0; i <= 9 && count != 2; i++) {
            if (frequency[i] == 0) {
                continue;
            }
            while (count != 2 && frequency[i]-- > 0) {
                if (isTest) {
                    System.out.println("digit: " + i);
                }
                if (isNum1) {
                    num1 = i;
                    isNum1 = false;
                } else {
                    num2 = i;
                    isNum1 = true;
                }
                count++;
            }
        }
        count = 0;
        for (int i = 0; i <= 9 && count != 2; i++) {
            if (frequency[i] == 0) {
                continue;
            }
            while (count != 2 && frequency[i]-- > 0) {
                if (isTest) {
                    System.out.println("digit: " + i);
                }
                if (isNum1) {
                    num1 *= 10;
                    num1 += i;
                    isNum1 = false;
                } else {
                    num2 *= 10;
                    num2 += i;
                    isNum1 = true;
                }
                count++;
            }
        }
        if (isTest) {
            System.out.println("after, frequency: " + Arrays.toString(frequency));
            System.out.println("-----------------------------------------------------");
            System.out.println("num1: " + num1 + "\nnum2: " + num2 + "\nsum: " + (num1 + num2));
        }

        return num1 + num2;
    }
}