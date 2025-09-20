// Question: https://leetcode.com/problems/split-with-minimum-sum/description/

class SplitWithMinimumSum {
    public int splitNum(int num) {
        boolean isTest = false;
        boolean isNum1 = true;
        int[] frequency = new int[10];
        int numCopy = num;
        int num1 = 0;
        int num2 = 0;

        while (numCopy > 0) {
            frequency[numCopy % 10]++;
            numCopy /= 10;
        }
        if (isTest) {
            System.out.println("num: " + num + "\nfrequency: " + Arrays.toString(frequency));
        }
        for (int i = 0; i <= 9; i++) {
            while (frequency[i]-- > 0) {
                if (isNum1) {
                    num1 *= 10;
                    num1 += i;
                    isNum1 = false;
                } else {
                    num2 *= 10;
                    num2 += i;
                    isNum1 = true;
                }
            }
        }
        if (isTest) {
            System.out.println("num1: " + num1 + "\nnum2: " + num2 + "\nminimum sum: " + (num1 + num2));
        }

        return num1 + num2;
    }
}